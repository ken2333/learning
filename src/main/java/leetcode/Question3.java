package leetcode;

import org.springframework.context.annotation.Bean;

/**
 * @author ken
 * @date 2019/8/27  21:05
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Question3 {

    public static void main(String[] args) {

        String s = "au";
        int max = 0;
        String maxStr = null;

        for (int i = 0; i < s.length(); i++) {
            String tem = null;
            char temchar;
            for (int k = i; k < s.length(); k++) {
                temchar = s.charAt(k);
                tem = s.substring(i, k);
                int i1 = tem.indexOf(temchar);
                if (i1 < k && i1 >= 0) {
                    int length = tem.length();
                    if (length > max) {
                        max = length;
                    }
                    break;
                } else {
                    int length = tem.length();
                    if (length > max) {
                        max = length;
                    }
                }
            }
        }
        System.out.println(max);
    }
}

