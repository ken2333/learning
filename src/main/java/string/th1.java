package string;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author ken
 * @date 2019/1/25  11:36
 * @description
 */
public class th1
{

    @Test
    public void test()
    {   //
        String[] s=new String[]{"1","2","3","4"};
        String join = StringUtils.join(s, ":");
        System.out.println(join);
        String[] split = join.split(",");
        System.out.println(split);
    }
    @Test
    public void test2()
    {
        String abcdefg = StringUtils.abbreviate("sunyehaosun", 6);
        System.out.println(abcdefg);

    }
    @Test
    public void test3() throws UnsupportedEncodingException {
        byte[] bytes = DigestUtils.sha256("123456");

    }
}
