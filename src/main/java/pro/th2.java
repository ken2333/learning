package pro;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ken
 * @date 2018-11-25  22:00
 * @description
 */
public class th2 {
    @Test
    public void test()
    {
        System.out.println(0x7F);
        System.out.println((byte)(1023 & 0x7F)|0x80);
        //8 1000
        //32 100000
        System.out.println(8<<2);
        System.out.println(8>>2);
        System.out.println(8>>2);
        System.out.println(Arrays.toString("小".getBytes()));
    }
}
