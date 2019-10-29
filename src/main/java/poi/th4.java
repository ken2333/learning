package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author syh
 * @date 2019/7/30  15:06
 * @description
 */
public class th4 {


    @Test
    public void test() throws IOException {
        FileInputStream in=new FileInputStream("C:\\Users\\kem\\Documents\\Tencent Files\\1176497634\\FileRecv\\test.xlsx");
        HSSFWorkbook workbook=new HSSFWorkbook(in);


    }
}
