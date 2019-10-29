package leetCode;

import pro.Test;

/**
 * describe:
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author syh
 * @date 2019/09/08
 */
public class Question9 {

    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        int length=s.length();
        String tem="";
        for (int i = 0; i < length; i++) {
            int index=length-(i+1);
            tem+=s.charAt(index);
        }
        return s.equals(tem);
    }


    public static boolean isPalindrome2(int x) {
        String s=String.valueOf(x);
        int length=s.length();
        boolean result=length%2==0?true:false;
        System.out.println( Math.sqrt(length+1));
        for (int i = 0; i <  (length/2+1); i++) {
            int tail=length-(i+1);
            if(s.charAt(tail)!=s.charAt(i))
            {
                return  false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(Question9.isPalindrome2(1000030001));
    }
}
