package base62x;

import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2020/05/31
 */
public class test {
    @Test
    public void test()
    {
        String encode = Base62x.encode("安居集团机关党支部2020年度“党建”党业融合++ - 副本.doc");
        System.out.println(encode);

        String decode = Base62x.decode(encode);
        System.out.println(decode);

    }
}
