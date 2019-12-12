package itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;

import java.io.*;

/**
 * @author ken
 * @date 2018-11-24  17:13
 * @description
 */
public class th1 {
    @Test
    public void test() throws IOException, DocumentException {

        Document document = new Document();
        OutputStream out = new FileOutputStream("E:\\tem\\tem.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese, 15);
        document.add(new Paragraph("1223321中文", font));
        document.add(new Paragraph("这是一段话", font));
        document.close();
        writer.close();
        if (out != null) {
            out.close();
        }

    }

    @Test
    public void test2() throws IOException, DocumentException {

        Document document = new Document(PageSize.A4);
        OutputStream out = new FileOutputStream("D:\\tem\\tem2.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, out);
        //字体
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //       BaseFont baseFont1 = BaseFont.createFont("D:\\ideaSpace\\Learning\\src\\main\\java\\itext\\wryh.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(bfChinese, 14);
        document.open();
        LineIterator lineIterator = FileUtils.lineIterator(new File("D:\\ideaSpace\\Learning\\src\\main\\java\\itext\\test1.txt"), "utf-8");
        document.addAuthor("sunyehao");
        Paragraph title = new Paragraph("标题------", font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.addKeywords("123456");
        while (lineIterator.hasNext()) {
       /*     String tem = lineIterator.next();
            System.out.println(tem);
            document.add(new Paragraph(tem, font));*/
        }
        document.close();
        writer.close();

    }

    @Test
    public void test3() throws IOException, DocumentException {
        Document document = new Document();
        OutputStream out = new FileOutputStream("E:\\tem\\tem.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese, 15);
        PdfPTable table=new PdfPTable(5);
        for(int i=0;i<15;i++)
        {
            PdfPCell cell=new PdfPCell(new Phrase("你好",font));
            table.addCell(cell);
        }
        document.add(table);
        document.close();
        writer.close();
        if (out != null) {
            out.close();
        }

    }

}
