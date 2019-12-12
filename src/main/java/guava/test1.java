package guava;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Ordering;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.zookeeper.Op;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ken
 * @date 2019/5/30  23:54
 * @description
 */
public class test1 {

    @Test
    public void test()
    {
        //设置一个值,如果纯在
        Optional<Integer> integer = Optional.of(10);
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(integer.isPresent());
        System.out.println(o.isPresent());
        try {
            Object o1 = o.orElse(1);
            //如果value是空，这会排除一个NoSuchElementException一个异常
            Object o2 = o.get();
            System.out.println(o1);
        }catch (NoSuchElementException e)
        {
            System.out.println(e.toString());
        }



    }

    @Test
    public void test2()
    {

        Preconditions.checkArgument(true);
        Preconditions.checkState(true);
        int i = Preconditions.checkElementIndex(1, 2);
        System.out.println(i);
        Preconditions.checkPositionIndexes(2,4,2);

    }
    @Test
    public void test3()
    {
        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        System.out.println(nullOrEmpty);
        String s = Strings.padStart("1001", 10, '0');
        System.out.println(s);

        Iterable<String> splitResults = Splitter.onPattern("[，,]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .split("hello,word,,世界，水平");

        for (String item : splitResults) {
            System.out.println(item);
        }
    }
    @Test
    public void test4()
    {
        HashBiMap<String, String> map = HashBiMap.create();
        map.put("id1", "cd1");
        map.put("id2", "cd2");
        map.put("id3", "cd3");
        map.put("id4", "cd4");
        System.out.println(map.get("id1")+":"+map.inverse().get("cd1"));
    }

    @Test
    public void test5() {
        Preconditions.checkArgument(true);
        try {
            /**
             * 检查参数是否为true，如果不为true就会报错
             */
            Preconditions.checkArgument(false);


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Preconditions.checkNotNull(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Preconditions.checkState(false,"错误提示");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            Preconditions.checkElementIndex(10,11);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //检查开始位置和结束位置是否在范围之内
        try {
            Preconditions.checkPositionIndexes(1,6,4);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test6() {
        List<Integer> array=new ArrayList<>();
        array.add(20);
        array.add(12);
        array.add(90);
        array.add(10);
        Ordering<Comparable> natural = Ordering.natural();
        natural.nullsFirst();
    }

    @Test
    public void test8() {
       EnumDay day=EnumDay.FRI;
        int ordinal = day.ordinal();
        System.out.println(ordinal);
        System.out.println(day.name());

        EnumSet<EnumDay> weekSet = EnumSet.allOf(EnumDay.class);
        Iterator<EnumDay> it = weekSet.iterator();
        while (it.hasNext()) {
            EnumDay tem=it.next();
            System.out.println(tem.name());
        }
    }

    @Test
    public void test9() {
        EnumSet<EnumDay> set=EnumSet.allOf(EnumDay.class);
        System.out.println(EnumDay.WED.getName());
    }
}
