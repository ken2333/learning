package poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ken
 * @date 2019/2/21  10:46
 * @description
 */
public class th3 {

    @Test
    public void test() throws IOException {
       /* HSSFWorkbook workbook=new HSSFWorkbook();*/
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);

        XSSFCell cell = row.createCell(2,CellType.NUMERIC);
        String formatStr ="#,##0.00";
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFDataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat(formatStr));
        cell.setCellStyle(style);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);

      //   cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue(new Double("123123.23"));
        OutputStream out=new FileOutputStream("e:\\tem\\sun.xlsx");

        workbook.write(out);

    }
}
