package test;

import org.junit.Test;

import java.util.List;

/**
 * @author ken
 * @date 2018-11-26  18:08
 * @description
 */
public class test {
    @Test
    public void test()
    {
        //通过服务
        HelloImplService helloImplService = new HelloImplService();
        Hello helloImplPort = helloImplService.getHelloImplPort();
        List<String> list = helloImplPort.getList();
        System.out.println(list);
        System.out.println(helloImplPort.hello());
    }

    @Test
    public void test2()
    {
        //String pat="[+#$%^&]*";
        String pat="[\\ /:*?'\"<>|+#^`$%&]*";
        String fileName="互%#&联$网^//:\"<>|^`（这是括号）（）（）（）(————)+.doc";
        fileName= fileName.replaceAll(pat, "");
        fileName=fileName.replaceAll("（","(");
        fileName=fileName.replaceAll("）",")");
        fileName=fileName.replaceAll("—","-");
        System.out.println(fileName);
    }
}
