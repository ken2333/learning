package fatory;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * @author ken
 * @date 2019/5/11  23:33
 * @description
 */
public class Test {

    public static void main(String[] args) throws IOException {

        Fatory<Integer> fatory=new MultiplicationFatory();
        Calculate<Integer> fatory1 = fatory.getFatory(10, 2);
        System.out.println(fatory1.getretsult());

        String tst="5a6J5bGF6ZuG5Zui5py65YWz5YWa5pSv6YOoMjAyMOW5tOW6puKAnOWFmuW7uuKAneWFmuS4muiejeWQiCAtIOWJr+acrC5kb2M=";
        String name=new String(new BASE64Decoder().decodeBuffer(tst),"utf-8");

        System.out.println(name);
        System.out.println(URLDecoder.decode("安居集团机关党支部2020年度“党建”党业融合%2B%2B%2B - 副本.doc", "utf-8"));

    }
}
