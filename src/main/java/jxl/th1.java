package jxl;

import jxl.format.*;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ken
 * @date 2019/2/21  11:41
 * @description
 */
public class th1 {

    @Test
    public void test() throws IOException, WriteException {
        OutputStream out=new FileOutputStream("F:\\ideaSpace\\Learning\\src\\main\\resources\\卡片列表.xls");
        WritableWorkbook workbook=Workbook.createWorkbook(out);
        WritableSheet first = workbook.createSheet("first", 0);
        Label label=new Label(0,0,"hello");
        first.addCell(label);
        Number number=new Number(0,1,123.23);
        first.addCell(number);
        workbook.write();
        workbook.close();
        CellView view=new CellView();
        view.setFormat(new CellFormat() {
            @Override
            public Format getFormat() {
                return null;
            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public boolean getWrap() {
                return false;
            }

            @Override
            public Alignment getAlignment() {
                return null;
            }

            @Override
            public VerticalAlignment getVerticalAlignment() {
                return null;
            }

            @Override
            public Orientation getOrientation() {
                return null;
            }

            @Override
            public BorderLineStyle getBorder(Border border) {
                return null;
            }

            @Override
            public BorderLineStyle getBorderLine(Border border) {
                return null;
            }

            @Override
            public Colour getBorderColour(Border border) {
                return null;
            }

            @Override
            public boolean hasBorders() {
                return false;
            }

            @Override
            public Colour getBackgroundColour() {
                return null;
            }

            @Override
            public Pattern getPattern() {
                return null;
            }

            @Override
            public int getIndentation() {
                return 0;
            }

            @Override
            public boolean isShrinkToFit() {
                return false;
            }

            @Override
            public boolean isLocked() {
                return false;
            }
        });
    }
}
