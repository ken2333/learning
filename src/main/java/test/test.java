package test;

import org.junit.Test;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ken
 * @date 2019/10/15  22:39
 * @description
 */
public class TEST {
    public static void main(String[] args) {
        System.out.println(123);
    }

    @Test
    public void test() {
        String url="http://test.dc.cszysoft.com:19417";
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());

        long longtime = System.currentTimeMillis();
        String str = "AnHui_Zx" + "zce".toUpperCase() + longtime;
        String token = new org.apache.shiro.crypto.hash.Md5Hash(str).toString().toUpperCase();
        System.out.println(longtime);
        System.out.println(token);
    }
}
