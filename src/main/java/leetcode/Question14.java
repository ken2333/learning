package leetCode;

/**
 * describe:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2019/09/09
 */
public class Question14 {
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length ==1)
            return  strs[0];
        if (length ==0)
            return "";
        String mix = strs[0];
        for (int i = 1; i < length; i++) {
            if (strs[i].length() < mix.length()) {
                mix = strs[i];
            }
        }
        int minLength = mix.length();
        for(int k=0;k<length;k++)
        {
            int i = 0;
            for (; i < length; i++) {
                if (strs[i].indexOf(mix) == -1) {
                    minLength=(minLength-1)>=0?(--minLength):0;
                    mix=mix.substring(0, minLength);
                    break;
                }
            }
            if(i==length-1)
                break;
        }
        return mix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "aa"}));
    }
}
