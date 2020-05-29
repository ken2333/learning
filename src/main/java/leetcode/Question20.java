package leetcode;

import org.apache.shiro.crypto.hash.Hash;
import org.springframework.context.annotation.Bean;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        ArrayList<String> list = new ArrayList<>();
        ArrayDeque<String> arrayDeque = new ArrayDeque();
        for (int i = 0; i < length; i++) {
            String m = s.substring(i, i + 1);
            String peek = arrayDeque.peek();
            if (peek != null) {
                switch (peek) {
                    case "(": {
                        if (")".equals(m)) {
                            arrayDeque.pop();
                        } else {
                            arrayDeque.push(m);
                        }
                        break;
                    }
                    case "[": {
                        if ("]".equals(m)) {
                            arrayDeque.pop();
                        } else {
                            arrayDeque.push(m);
                        }
                        break;
                    }
                    case "{": {
                        if ("}".equals(m)) {
                            arrayDeque.pop();
                        } else {
                            arrayDeque.push(m);
                        }
                        break;
                    }
                }
            } else {
                arrayDeque.push(m);
            }

        }
        if (arrayDeque.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValid2(String s) {

        int length = s.length();
        ArrayList<String> arrayDeque = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String m = s.substring(i, i + 1);
            if (arrayDeque.size() == 0) {
                arrayDeque.add(m);
                continue;
            }
            String peek = arrayDeque.get(arrayDeque.size() - 1);
            if (peek != null) {
                switch (peek) {
                    case "(": {
                        if (")".equals(m)) {
                            arrayDeque.remove((arrayDeque.size() - 1));
                        } else {
                            arrayDeque.add(m);
                        }
                        break;
                    }
                    case "[": {
                        if ("]".equals(m)) {
                            arrayDeque.remove((arrayDeque.size() - 1));

                        } else {
                            arrayDeque.add(m);
                        }
                        break;
                    }
                    case "{": {
                        if ("}".equals(m)) {
                            arrayDeque.remove((arrayDeque.size() - 1));

                        } else {
                            arrayDeque.add(m);
                        }
                        break;
                    }
                }
            } else {
                arrayDeque.add(m);
            }

        }
        if (arrayDeque.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        //System.out.println(isValid("()"));
        System.out.println(isValid2("()[]{}"));
    }
}
