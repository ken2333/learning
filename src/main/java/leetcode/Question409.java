package leetcode;

/**
 * describe:
 * <p>
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author syh
 * @date 2020/03/19
 */
public class Question409 {
    public static int longestPalindrome(String s) {
        int[] i = new int[128];
        for (int k = 0; k < s.length(); k++) {
            int index = (int) s.charAt(k);
            ++i[index];
        }
        boolean flag = false;
        int result = 0;
        for (int k = 65; k < 123; k++) {
            if (i[k] % 2 == 0) {
                result += i[k];
            } else {
                result += (i[k] - 1);
                flag = true;
            }
        }
        if (flag)
            result++;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababababa"));
    }

}
