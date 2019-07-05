package guava;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author ken
 * @date 2019/5/30  23:54
 * @description
 */
public class test1 {

    @Test
    public void test()
    {
        //设置一个值
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
}
