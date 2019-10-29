package leetCode;

/**
 * describe:
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2019/09/08
 */
public class Question7 {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        Long result =0l;

        if(sb.toString().indexOf("-")!=-1)
        {
            result=-Long.parseLong(sb.substring(0,length-1));
        }
        else
            result= Long.parseLong(sb.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return  result.intValue();
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 31) - 1 == Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Math.pow(2, 31) == Integer.MIN_VALUE);
        System.out.println(Question7.reverse(1534236469
        ));
    }
}
