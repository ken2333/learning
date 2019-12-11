package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * describe:
 *
 * @author syh
 * @date 2019/11/22
 */
public class SaxTest {

    public static void main(String[] args) {
        //1.或去SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.获取SAXparser实例
        //创建Handel对象
        SAXDemoHandel handel = new SAXDemoHandel();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("src/resources/form.xml",handel);
            System.out.println();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
