package common.lang3;

import org.apache.commons.lang3.RegExUtils;
import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/11
 */
public class RegExUtilsTest {


    @Test
    public void test() {
        String s = RegExUtils.removeAll("asd123,12312sad", "\\d+");
        System.out.println(s);
    }
}
