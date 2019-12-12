package common.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/11
 */
public class ArrayUtilsTest {
    @Test
    public void test() {
        String[] strings = new String[]{"第一", "第二", "第三","第四"};

        String[] add = ArrayUtils.add(strings, "12321");

        for (String string : strings) {
            System.out.println(string);
        }

        for (String s : add) {
            System.out.println(s);
        }

        /**
         * 复制数组
         */
        String[] strings2 = ArrayUtils.clone(strings);
        System.out.println(strings2 == strings);

        /**
         * 是否包含
         */
        System.out.println(ArrayUtils.contains(strings, "第一"));


        int i = ArrayUtils.hashCode(strings);
        System.out.println(i);
        int i1 = ArrayUtils.hashCode(strings2);
        System.out.println(i1);


        /**
         * 确定位置
         */
        System.out.println(ArrayUtils.indexOf(strings, "第一"));


        /**
         * 数组的类型是否相同
         */
        System.out.println(ArrayUtils.isSameType(strings, strings2));


        /**是否排序
         *
         */
        int[] intarr = new int[]{1, 2, 3, 4, 5, 6};
        int[] intarr2 = new int[]{6, 4, 9, 6};
        System.out.println(ArrayUtils.isSorted(intarr));
        System.out.println(ArrayUtils.isSorted(intarr2));

        /**
         * 填充默认值
         */
        intarr=new int[10];
        ArrayUtils.nullToEmpty(intarr);
        System.out.println(intarr.length);

        /**
         * 倒转数组
         */
        ArrayUtils.reverse(strings);
        for (String string : strings) {
            System.out.println(string);
        }

        /**
         * 弹出元素
         */
        System.out.println();
        ArrayUtils.shift(strings,1);
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println();
        ArrayUtils.shuffle(strings2);
        for (String s : strings2) {
            System.out.println(s);
        }


        /**
         * 初始化数组
         */
        int  [] intarr3 = (int[]) ArrayUtils.toPrimitive(intarr);
        for (int i2 : intarr3) {
            System.out.println(i2);
        }

    }


}
