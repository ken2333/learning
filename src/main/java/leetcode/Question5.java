package leetCode;

/**
 * describe:
 *
 * @author syh
 * @date 2019/08/29
 */
public class Question5 {


    public static String longestPalindrome(String s) {
        int length = s.length();
        String longestPalindrome="";
        for (int i = 0; i < length; i++) {
            for (int k = i; k < length; k++) {
                String tem=s.substring(i,k);
                for(int j=tem.length()-1;j>=0;j--)
                {
                    if (tem.charAt(tem.length()-j)!=tem.charAt(j)) {
                     break;
                    }
                    if(j==0&& tem.length()>longestPalindrome.length())
                    {
                       longestPalindrome=tem;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababksab"));
    }
}
