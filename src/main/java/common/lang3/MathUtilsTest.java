package common.lang3;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/11
 */
public class MathUtilsTest {

    @Test
    public void test() {
        boolean digits = NumberUtils.isDigits("1232");
        Double aDouble = NumberUtils.createDouble("123.1");
        System.out.println(digits);
        System.out.println(aDouble);
        boolean creatable = NumberUtils.isCreatable("123.1");
        System.out.println(creatable);
    }
}
