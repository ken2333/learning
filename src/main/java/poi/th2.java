package poi;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ken
 * @date 2018-12-10  12:31
 * @description 操作execle
 */
public class th2 {
    @Test
    public void test() throws IOException {
        FileInputStream in = new FileInputStream("E:\\works\\GX_FC\\资料\\1212全区维护管理员管理区域情况表.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(in);
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        int lastRowNum = sheetAt.getLastRowNum();
        Iterator<Row> iterator = sheetAt.iterator();
        while (iterator.hasNext()) {
            Row next = iterator.next();
            Iterator<Cell> iterator1 = next.iterator();
            while (iterator1.hasNext()) {
                Cell cell = iterator1.next();
                CellType cellTypeEnum = cell.getCellTypeEnum();
                switch (cellTypeEnum.name()) {
                    case "STRING": {
                        System.out.println(cell.getStringCellValue());
                        break;
                    }
                    case "NUMERIC": {
                        System.out.println(cell.getNumericCellValue());
                        break;
                    }
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        FileInputStream in = new FileInputStream("F:\\ideaSpace\\Learning\\src\\main\\resources\\卡片列表.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);
        hssfWorkbook.getSheetAt(0);

    }

    @Test
    public void test3() {
        String str = "2018-10-12 20:22.0";
        System.out.println(str.substring(0, str.indexOf('.')));
        String lkajdlkas = "asdasdssasdasd";

    }
// TODO: 2020/5/15 sssdsad 
    
    @Test
    public void test4() throws IOException {
        FileInputStream inputStream = new FileInputStream("F:\\ideaSpace\\Learning\\src\\main\\resources\\资产月报表.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        List<String> list = new ArrayList<>();
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        int lastRowNum = sheetAt.getLastRowNum();

        for (int i = 0; i < lastRowNum; i++) {
            HSSFRow row = sheetAt.getRow(i);
            short lastCellNum = row.getLastCellNum();
            String tem = "";
            for (int k = 1; k < lastCellNum; k++) {
                HSSFCell cell = row.getCell(k);
                CellAddress address = cell.getAddress();
                String value = cell.getStringCellValue();
                if ((StringUtils.isEmpty(value) || value.equals("合计") || value.equals("小计")))
                    continue;
                System.out.println("address:" + address.toString());
                System.out.println("value:" + value);
                if (lastCellNum - 1 == k) {
                    for (int m = k - 1; m > 0; m--) {
                        HSSFCell cell1 = row.getCell(m);
                        String value1 = cell1.getStringCellValue();
                        tem += m + ":" + value1;
                    }
                }
                list.add(tem);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test6() throws IOException {
        FileInputStream inputStream = new FileInputStream("F:\\ideaSpace\\Learning\\src\\main\\resources\\资产月报表.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        List<CellRangeAddress> mergedRegions = sheetAt.getMergedRegions();
        //removeOther(mergedRegions,sheetAt);
        List<String> list = new ArrayList<>();
        for (int i = 7; i < sheetAt.getLastRowNum(); i++) {
            HSSFRow row = sheetAt.getRow(i);
            short lastCellNum = row.getLastCellNum();
            for (int k = 1; k < lastCellNum; k++) {
                HSSFCell cell = row.getCell(k);
                CellAddress address = cell.getAddress();
                String value = cell.getStringCellValue();
                //排除不需要的部分
                if ((StringUtils.isEmpty(value) || value.equals("合计") || value.equals("小计")))
                    continue;
                int newRow = address.getRow();
                int column = address.getColumn();
                PriorityQueue<TypeNode> father1 = getFathers(newRow, column, mergedRegions);
                if (father1 != null) {
                    String faterValue = "";
                    while (!father1.isEmpty()) {
                        TypeNode poll = father1.poll();
                        Cell abosuteIndex = getAbosuteIndex(sheetAt, poll.getRow(), poll.getColumn());
                        String abosuteIndexstr = abosuteIndex.getStringCellValue();
                        if (!abosuteIndexstr.equals("合计") && !abosuteIndexstr.equals("小计")) {
                            faterValue += abosuteIndexstr + "->";
                        }
                    }
                    list.add(faterValue + value);
                }
            }
        }
        System.out.println(list);
    }

    @Test
    public void test5() throws IOException {
        FileInputStream inputStream = new FileInputStream("F:\\ideaSpace\\Learning\\src\\main\\resources\\资产月报表.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        List<String> list = new ArrayList<>();
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        List<CellRangeAddress> mergedRegions = sheetAt.getMergedRegions();

        for (CellRangeAddress mergedRegion : mergedRegions) {
            String[] split = mergedRegion.formatAsString().split(":");
            if (split[0].substring(0, 1).equals(split[1].substring(0, 1))) {
                System.out.println(mergedRegion.formatAsString("GDZCYBB-资产月报表", true));
                int numberOfCells = mergedRegion.getNumberOfCells();
                System.out.println(numberOfCells);

            }
        }
    }

    //获取父节点
    public Integer[] getFather(int nowRow, int column, List<CellRangeAddress> list) {
        Integer[] s = null;
        for (CellRangeAddress cellRangeAddress : list) {
            if (cellRangeAddress.containsRow(nowRow)) {
                int firstColumn = cellRangeAddress.getFirstColumn();
                if (column != firstColumn) {
                    s = new Integer[]{cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn()};
                    break;
                }
            }
        }
        return s;
    }

    /*根据指定的位置来获取cell*/
    public Cell getAbosuteIndex(HSSFSheet sheet, int row, int colum) {
        HSSFRow row1 = sheet.getRow(row);
        HSSFCell cell = row1.getCell(colum);
        return cell;
    }


    //获取当前cell的所有父类型，返回一个带有排序的优先队列，其中祖父节点在最前面
    public PriorityQueue getFathers(int nowRow, int column, List<CellRangeAddress> list) {
        PriorityQueue<TypeNode> typeNodes = new PriorityQueue<>();
        //遍历所有地址，如果是当前节点的父节点，或者祖父节点都加入
        for (CellRangeAddress cellRangeAddress : list) {
            if (cellRangeAddress.containsRow(nowRow)) {
                int firstColumn = cellRangeAddress.getFirstColumn();
                //若果列相等，则代表是同各一个节点，不需要加入
                if (column != firstColumn) {
                    typeNodes.add(new TypeNode(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getNumberOfCells()));
                }
            }
        }
        return typeNodes;
    }

    @Test
    public void test7() {
        PriorityQueue<TypeNode> typeNodes = new PriorityQueue<>();
        typeNodes.add(new TypeNode(12, 1, 42));
        typeNodes.add(new TypeNode(112, 1, 4));
        typeNodes.add(new TypeNode(122, 1, 66));
        typeNodes.add(new TypeNode(132, 1, 22));
        while (!typeNodes.isEmpty()) {
            TypeNode poll = typeNodes.poll();
            System.out.println(poll);
        }
    }

    public void removeOther(List<CellRangeAddress> list, HSSFSheet sheet) {
        List<CellRangeAddress> removeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            CellRangeAddress cellRangeAddress = list.get(i);
            Cell abosuteIndex = getAbosuteIndex(sheet, cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn());
            String value = abosuteIndex.getStringCellValue();
            if (value.equals("合计") || value.equals("小计"))
                removeList.add(cellRangeAddress);
        }
        for (int i = 0; i < removeList.size(); i++) {
            list.remove(removeList.get(i));
        }
    }

    @Test
    public void test8() throws UnsupportedEncodingException {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());
        String str = "你好";
        byte[] bytes = str.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        byte[] bytes1 = str.getBytes("utf-8");
        System.out.println("utf-8");
        for (byte b : bytes1) {
            System.out.println(b);
        }
    }

    @Test
    public void test9() {

        String[] s = new String[]{"1111", "2222", "333"};
        List<String> s2 = new ArrayList<>();
        s2.add("111");
        s2.add("222");
        System.out.println(StringUtils.join());

    }

    private static final Pattern p_html = Pattern.compile("<[a-zA-z]{1,9}((?!>).)*>", Pattern.CASE_INSENSITIVE);

    private static final Pattern t_html = Pattern.compile("</[a-zA-z]{1,9}>", Pattern.CASE_INSENSITIVE);

    @Test
    public void test10() {
        Pattern p_html = Pattern.compile("<[a-zA-z]{1,9}((?!>).)*>", Pattern.CASE_INSENSITIVE);
        Pattern t_html = Pattern.compile("</[a-zA-z]{1,9}>", Pattern.CASE_INSENSITIVE);
        String html = "<p style=\"text-align: left; line-height: 5em; text-indent: 2em;\">收到请ssssssssssssssss<img class=\"currentImg\" id=\"currentImg\" src=\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587730945342&di=82c94e2e523d97a2c96b43555f4b9671&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg\" style=\"top: 48px; left: 254px; width: 574.667px; height: 431px; cursor: pointer;\" title=\"点击查看源网页\" width=\"574.66666666667\" height=\"431\"/></p>";
        Matcher m_script = p_html.matcher(html);

        html = m_script.replaceAll("");

        Matcher l_script = t_html.matcher(html);

        System.out.println(l_script.replaceAll(""));

    }


}
