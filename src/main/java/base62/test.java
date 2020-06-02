package base62;

import io.seruco.encoding.base62.Base62;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * describe:
 *
 * @author syh
 * @date 2020/05/31
 */
public class test {
    @Test
    public void test() throws UnsupportedEncodingException {

        Base62 base62 = Base62.createInstance();
        final byte[] encoded = base62.encode("安居集团机关党支部2020年度“党建”党业融合 - 副本.doc".getBytes());

       String trsul= new String(encoded); // is "73XpUgyMwkGr29M"
        System.out.println(trsul);

        byte[] decode = base62.decode(trsul.getBytes("utf-8"));
        System.out.println(new String(decode));


    }

}
