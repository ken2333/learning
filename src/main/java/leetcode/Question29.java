package leetcode;

/**
 * describe:
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * @author syh
 * @date 2020/03/19
 */
public class Question29 {

    public static int divide(int dividend, int divisor) {
        boolean flag = false;
        if (dividend < 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        } else if (dividend < 0 || divisor < 0) {
            dividend = dividend < 0 ? -dividend : dividend;
            divisor = divisor < 0 ? -divisor : divisor;
            flag = true;
        }

        if (dividend < dividend) {
            return 0;
        }
        int result = 0;
        long count = 0;
        while ((result = dividend - divisor) >= 0) {
            count++;
            dividend -= divisor;
        }
        if (flag) {
            count = -count;
        }
        if (count > Integer.MAX_VALUE || count < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) count;
    }

    public static void main(String[] args) {
        System.out.println(divide(7, -3));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(4&4);
    }
}
