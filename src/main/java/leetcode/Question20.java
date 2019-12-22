package leetcode;

import org.apache.shiro.crypto.hash.Hash;

import java.util.HashSet;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question20 {

    public static boolean isValid(String s) {
        int length = s.length();
        HashSet<Integer> integers = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c)
            {
                case  '(':
                {

                    break;
                }
            }
        }

        return false;
    }

    public static int getIndex(String string, char search, int start, int end) {
        int result = -1;
        for (; start <= end; end--) {
            if (search == string.charAt(end)) {
                result = end;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(()("));
    }
}
