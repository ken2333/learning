package common.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/05
 */
public class StringUtilsTest {

    @Test
    public void test1() {
        String str = null;
        Boolean b = false;
        Integer i;
        //缩写字符串
        String str1 = StringUtils.abbreviate("这个一段话的123", 5);
        System.out.println(str1);

        String str2 = StringUtils.abbreviate("这个一段话的11111112345", 5, 10);
        System.out.println(str2);

        //从中间缩小字符串
        String str3 = StringUtils.abbreviateMiddle("一则“北大博士后出国20年杳无音讯，病危老母亲盼见儿子最后一面”的消息引发关注", "。", 8);
        System.out.println(str3);

        /**
         *  如果末尾存在后缀就添加，如果没有就不添加
         */
        System.out.println(StringUtils.appendIfMissing("abc", "xyc"));

        /**
         *  第一个字母大写
         */
        String str4 = StringUtils.capitalize("abcd");
        System.out.println(str4);

        /**
         * 如果字符串的长度小于指定的长度，就会在字符串的两边填充空格达到指定的长度
         * 和居中的效果类似
         */
        String str5 = StringUtils.center("abcd", 8);
        System.out.println(str5);


        /**
         *  移除字符串末尾的一个换行符号，包括了"\n", "\r", or "\r\n".
         */
        String chomp = StringUtils.chomp("sun\n");
        System.out.println(chomp);

        /**
         *  移除字符串末尾的最后一个字符串
         */
        String chop = StringUtils.chop("abcd");
        System.out.println(chop);

        /**
         * 比较两个字符串的大小，类似比较asii码的大小
         * 0，表示相等
         * 1表示str1大于str2
         * -1表示str2大于str1
         */
        int compare = StringUtils.compare("a", "b");
        System.out.println(compare);

        /**
         * 搜索字符串，是否包含有相应的搜索字符串
         */
        boolean b1 = StringUtils.contains("sun", "s");
        System.out.println(b1);


        boolean b2 = StringUtils.contains("sun", 115);
        System.out.println(b2);

        /**
         *  用于检查字符串组成的字符是否，在validChars都有，如果都有返回true,如果有一个没有返回false
         */
        boolean b3 = StringUtils.containsOnly("abab", "abc");

        /**
         * 检查是否字符串是否包含空格
         */
        boolean b4 = StringUtils.containsWhitespace("222");
        System.out.println(b4);

        /**
         * 计算字符串包含的次数
         *
         */
        int i1 = StringUtils.countMatches("1aaa", 'a');
        System.out.println(i1);

        /**
         * 如果字符串为空，就返回默认的值
         */
        str = StringUtils.defaultIfBlank(" ", "");
        System.out.println(str);


        /**
         * 如果参数是空就返回默认值，string的默认值是“”
         */
        str = StringUtils.defaultString(null);
        System.out.println(str.length());

        /**
         * 删除所有的空格
         */
        str = StringUtils.deleteWhitespace(" asdas aslkdjaslkdjas djk");
        System.out.println(str);

        /**
         * 比较两个字符串的差异，它是从头开始检查差异的
         */
        str = StringUtils.difference("abcdef", "abcde");
        System.out.println(str);

        /**
         * 检查结尾是否是指定的字符串.
         */
        b = StringUtils.endsWith("abcdef", "ef");
        System.out.println(b);

        /**
         * 比较两个字符串是否相等
         */
        b = StringUtils.equals(null, null);
        System.out.println(b);

        /**
         * 和多个字符串比较是相等，只要有一个相等就返回true
         */
        b = StringUtils.equalsAny(null, null);
        System.out.println(b);

        /**
         *返回从输入的参数中，返回一个不为空的字符串
         */
        str = StringUtils.firstNonBlank(null, " ", "", "abc0");
        System.out.println(str);

        /**
         * 获取字符串的相同的前缀
         */
        str = StringUtils.getCommonPrefix("abc", "abcd");
        System.out.println(str);

        /**
         *  获取字符串包含的数字
         */
        str = StringUtils.getDigits("sun123321");
        System.out.println(str);

        /**
         * 搜索索引的位置
         */
        i = StringUtils.indexOf("sunyehao", "");
        System.out.println(i);

        /**
         * 搜索字符串的位置,
         */
        i = StringUtils.indexOfAny("abcde", "abc", "de");
        System.out.println(i);

        /**
         * 是否所有的参数都是空
         */
        b = StringUtils.isAllBlank(" ", " ", null);
        System.out.println(b);

        /**
         * 是否所有的字符都是小写,注意如果有空格或者其他的符号都会返回false
         */
        b = StringUtils.isAllLowerCase("assunasdasd");
        System.out.println(b);


        /**
         * 检查是否有大小写
         */
        b = StringUtils.isMixedCase("abC");
        System.out.println(b);


        /**
         * 检查是字符串是否是数字，主要这里不支持小数点，所以12.1会直接返回false
         */
        b = StringUtils.isNumeric("123.2");
        System.out.println(b);


        /**
         * 在字符串中添加分隔符，返回一个字符串
         */
        String[] sun = new String[]{"123", "321"};
        str = StringUtils.join(sun, ":");
        System.out.println(str);

        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("456");
        str = StringUtils.join(list ,",");
        System.out.println(str);

        str= StringUtils.joinWith(",", new String[]{"a","b"});
        System.out.println(str);

        /**
         * 获取最左边长度为4的字符串
         */
        str=StringUtils.left("abcdefghigk",4);
        System.out.println(str);

        /**
         * 往左边填充空格
         */
        str=StringUtils.leftPad("abc",10);
        System.out.println(str);

        int length = StringUtils.length("123321");
        System.out.println(length);

        str=StringUtils.normalizeSpace("http://www.w3.org/TR/xpath/#function-normalize -space");
        System.out.println(str);

        /**
         * 在字符串指定，第几个搜索字符串的位置
         */
        i=StringUtils.ordinalIndexOf("aabaabaa", "b", 3);
        System.out.println(i);

        /**
         * 指定字符的位置覆盖，或者添加指定的字符
         */

        str=StringUtils.overlay("abcdefg","123321",3,3);
        System.out.println(str);


        /**
         * 假如字符没有指定的开头，就会在开头加上指定的字符串
         */

        str= StringUtils.prependIfMissing("XYZabc", "xyz");
        System.out.println(str);

        /**
         * 移除字符串指定的字符
         */
        str=StringUtils.remove("apple",'p');
        System.out.println(str);

        /**
         * 移除字符串末尾的指定字符串
         *
         */
        str=StringUtils.remove("abcde","de");
        System.out.println(str);

        /**
         *  重复几次字符串
         */
        str=StringUtils.repeat("abc",3);
        System.out.println(str);

        /**
         * 替换指定的字符串
         */
        str=StringUtils.replace("abcdef","cd","  idknok");
        System.out.println(str);

        /**
         * 倒转字符串
         */
        str=StringUtils.reverse("abcdefghijk");
        System.out.println(str);


        /**
         * 截取最右边的指定长度的字符串
         */
        str=StringUtils.right("孙12321123",5);
        System.out.println(str);


        /**
         * 循环字符的数量
         */
        str=StringUtils.rotate("abcdefg",2);
        System.out.println(str);


        /**
         * 删除开始和末尾的空格
         */
        str=StringUtils.strip("  sun sds asdas  ");
        System.out.println(str);

        /**
         * 删除变音符，例如 éclair 变成eclair
         */
        str=StringUtils.stripAccents("éclair");
        System.out.println(str);


        /**
         * 转换字符串成
         */
        int arr[]  =StringUtils.toCodePoints("你好");
        for (int i2 : arr) {
            System.out.print(i2+",");
        }


        str=StringUtils.toEncodedString("霓虹".getBytes(), Charset.forName("utf-8"));
        System.out.println(str);
    }


}
