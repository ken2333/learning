package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Question17 {
      List<String> strings = new ArrayList<>();
      List<String> result = new ArrayList<>();

    public   List<String> letterCombinations(String digits) {
        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.add("jkl");
        strings.add("mno");
        strings.add("pqrs");
        strings.add("tuv");
        strings.add("wxyz");

        digui(digits, 0, "");
        return result;
    }

    public   void digui(String digits, int start, String tem) {
        int length = digits.length();
        if (length == 0) {
            return;
        }
        int index = Integer.parseInt(String.valueOf(digits.charAt(start)))-2;
        String fortem = strings.get(index);
        for (int i = 0; i < fortem.length(); i++) {
            String m = tem+String.valueOf(fortem.charAt(i));
            if ((start + 1) == length) {
                result.add(m);
            }else {
                digui(digits,start+1,m);
            }
        }
    }

    public static void main(String[] args) {
        Question17 test=new Question17();
        List<String> list = test.letterCombinations("2233");
        list.forEach(s-> System.out.println(s));
    }
}
