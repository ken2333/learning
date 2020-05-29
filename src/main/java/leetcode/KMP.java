package leetcode;

/**
 * describe:
 *
 * @author syh
 * @date 2020/03/19
 */
public class KMP {
    static void GetNext(String p, int next[]) {
        int pLen = p.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < pLen - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABCDABC";
        int[] i = new int[s.length()];
        GetNext(s, i);
        System.out.println(i);
    }
}
