package math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author ken
 * @date 2019/3/21  14:35
 * @description
 */
public class DoubleTest {

    @Test
    public void test()
    {
        BigDecimal weix = new BigDecimal("56");
        BigDecimal value = new BigDecimal("460");
        BigDecimal divide = weix.divide(value,2,BigDecimal .ROUND_HALF_UP);
        System.out.println(divide.toPlainString());
        System.out.println(divide.toString());
        System.out.println(divide.multiply(new BigDecimal(100)).round(MathContext.DECIMAL32));

    }
}
