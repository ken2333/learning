package poi;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author ken
 * @date 2018-12-2  22:27
 * @description
 */
public class th1 {
    @Test
    public void test() throws IOException {
        InputStream is = new FileInputStream("D:\\works\\FE_YF_CZ\\FE_YF_CZ\\src\\正文 (4).doc");
        WordExtractor extractor = new WordExtractor(is);
        //输出word文档所有的文本
        System.out.println(extractor.getText().trim().length());
        System.out.println(extractor.getTextFromPieces());


    }

    @Test
    public void test2() throws IOException {
        InputStream in = new FileInputStream("D:\\ideaSpace\\Learning\\src\\main\\resources\\正文.docx");
        XWPFDocument document=new XWPFDocument(in);
        XWPFWordExtractor extractor=new XWPFWordExtractor(document);
        List<XWPFPictureData> pictures = document.getAllPictures();
        for(XWPFPictureData picture:pictures)
        {
            String fileName = picture.getFileName();
            byte[] data = picture.getData();
            FileUtils.writeByteArrayToFile(new File("d:\\tem\\"+fileName),data);
        }
        String text = extractor.getText();
        System.out.println(text);

    }
}
