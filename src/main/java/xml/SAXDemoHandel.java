package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * describe:
 *
 * @author syh
 * @date 2019/11/22
 */
public class SAXDemoHandel extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("开始解析!!");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("结束解析!!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("workflowname"))
        {
            int length=attributes.getLength();
            for (int i = 0; i < length; i++) {
                System.out.println(attributes.getValue(i));
                System.out.println(attributes.getQName(i));
            }
        }
    }



}
