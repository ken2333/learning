package leetCode;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * describe:
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author syh
 * @date 2019/09/08
 */
public class Question6 {
    public static String convert(String s, int numRows) {
        long start=System.currentTimeMillis();
        if(numRows==1)
            return s;
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuilder();
        }
        int length = s.length();
        boolean flag= true;
        int index=0;
        for (int i = 0; i < length; i++) {
             strings[index]=strings[index].append(s.charAt(i));
            if(flag)
            {
                if((index+1)<numRows)
                    index++;
                else
                {
                    index--;
                    flag=false;
                }
            }else{
                if((index-1)>=0)
                    index--;
                else
                {
                    index++;
                    flag=true;
                }

            }
        }
        String tem = "";
        for (int i = 0; i < strings.length; i++) {
            tem += strings[i].toString();
        }
        long end=System.currentTimeMillis();
        System.out.println("测试服务器"+(end-start));
        return tem;
    }

    public static void main(String[] args) {
        String leetcodeishiring = Question6.convert("LEETCODEISHIRING", 3);
        System.out.println(leetcodeishiring);
        String leetcodeishiring2 = Question6.convert("LEETCODEISHIRING", 4);
        System.out.println(leetcodeishiring2);
    }
}
