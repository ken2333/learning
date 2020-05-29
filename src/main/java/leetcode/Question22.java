package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2020/03/14
 */
public class Question22 {
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

    public static List<String> generateParenthesis(int n) {
        int size = n * 2 - 2;
        String[] strings = new String[]{"(", ")"};
        test(strings,size,size,"");
        ArrayList<String> result = new ArrayList<>();
        list.forEach(ob->{
            String tem="("+ob+")";
            if(isValid(tem))
            {
                result.add(tem);
            }
        });
        return result;
    }


    private static ArrayList<String> list = new ArrayList<>();

    public static void test(String[] strings, int count, int size,String result) {
        if (count > 0) {
            int length = strings.length;
            for (int i = 0; i < length; i++) {
                test(strings, count - 1, size,result + strings[i]);
            }
        }
        if (result.length() == size)
            list.add(result);
    }

    public static void main(String[] args) {

        List<String> list = generateParenthesis(1);
        System.out.println(list);

    }

}
