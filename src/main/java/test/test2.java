package test;

import org.springframework.util.Assert;

/**
 * @author ken
 * @date 2019/5/23  23:23
 * @description
 */
public class test2 {
    public static void main(String[] args) {
            int i=1|4;
        System.out.println(i);
        System.out.println( 1 << 2);


        try {
            String s=null;
            Assert.notNull(s,"不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(123321);

    }
}
