package decode;

import org.junit.Test;
import sun.misc.BASE64Decoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * describe:
 *
 * @author syh
 * @date 2020/01/14
 */
public class test {

    private static  String content="阿克苏来得及卢卡斯的";

    @Test
    public void test() throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(content.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(digest));
    }

}
