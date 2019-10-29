package itext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * describe:
 *
 * @author syh
 * @date 2019/10/21
 */
public class htmltopdf {

    public static void main(String[] args) throws IOException {
        ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        String FONT = "E:\\ideaSpace\\Learning\\src\\main\\java\\itext\\TC-SemiBold.otf";
        defaultFontProvider.addFont(FONT);
        props.setFontProvider(defaultFontProvider);
        PdfWriter writer = new PdfWriter("E:\\tem\\tem.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(595.0F, 842.0F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream("E:\\ideaSpace\\Learning\\src\\main\\java\\html2.html"), pdf, props);
        document.close();
        pdf.close();
    }
}
