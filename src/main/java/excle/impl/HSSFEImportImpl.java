package excle.impl;

import excle.ExcleImport;
import excle.relation.TableConfig;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/02
 */
@Data
public class HSSFEImportImpl extends ExcleImport {
    Logger logger = LoggerFactory.getLogger(HSSFEImportImpl.class);

    private InputStream inputStream;


    private TableConfig config;

    //sheet的位置
    private int sheetIndex;

    //title的位置
    private int titleIndex;

    private int startIndex;

    @Override
    public void importFile() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheetAt = workbook.getSheetAt(sheetIndex);
        int lastRowNum = sheetAt.getLastRowNum();
        List<List<Object>> list = new ArrayList<>();
        for (int i = startIndex; i <= lastRowNum; i++) {
            List<Object> tem = new ArrayList<>();
            HSSFRow row = sheetAt.getRow(i);
            short lastCellNum = row.getLastCellNum();
            for (int k = 0; k < lastCellNum; k++) {
                HSSFCell cell = row.getCell(k);
                CellType cellTypeEnum = cell.getCellTypeEnum();
                switch (cellTypeEnum) {
                    case NUMERIC: {
                        double numericCellValue = cell.getNumericCellValue();
                        tem.add(numericCellValue);
                        break;
                    }
                    case STRING: {
                        String stringCellValue = cell.getStringCellValue();
                        tem.add(stringCellValue);
                        break;
                    }
                    /*case FORMULA:
                    {
                        break;
                    }*/
                    case ERROR:
                    {
                        throw new Exception("poi解析数据错误！");
                    }
                    default:{
                        tem.add(null);
                    }
                }
                list.add(tem);
            }
        }

    }

    @Override
    public void simpleCheck() {


    }

    @Override
    public void parseData() {

    }

    @Override
    public void saveData() {

    }

}
