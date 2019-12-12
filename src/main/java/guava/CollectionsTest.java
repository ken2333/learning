package guava;

import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/12
 */
public class CollectionsTest {
    String[] strings = new String[]{"语文", "数学", "英语"};

    @Test
    public void test() {

        List<String> list = Lists.newArrayList();

        ArrayList<String> strings1 = Lists.newArrayList(strings);
        strings1.forEach((s) -> System.out.println(s));

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        System.out.println(integers);

        ArrayList<Integer> integers1 = Lists.newArrayList(integers.iterator());


        CopyOnWriteArrayList<String> strings2 = Lists.newCopyOnWriteArrayList(strings1);
        System.out.println(strings2);

        List<List<String>> lists = Lists.cartesianProduct(strings2);
        System.out.println(lists);

        int count = Iterables.frequency(strings1, "语文");
        System.out.println(count);
    }

    @Test
    public void test2() {
        HashSet<String> objects = Sets.newHashSetWithExpectedSize(1);
        objects.add("123");
        objects.add("1234");
        objects.forEach((s) -> System.out.println(s));

        ImmutableSet<EnumDay> enumDays = Sets.immutableEnumSet(EnumDay.FRI, EnumDay.WED);
        enumDays.forEach((item) -> System.out.println(item.getName()));


        //求连个集合的合集
        HashSet<String> c = Sets.newHashSet("c++", "c", ".net");
        HashSet<String> c2 = Sets.newHashSet("java", "c", "python");
        Sets.SetView<String> reult = Sets.union(c, c2);
        reult.forEach((s) -> System.out.print("  " + s));

        //求交集
        Sets.SetView<String> result2 = Sets.intersection(c, c2);
        System.out.println("-----------------");
        result2.forEach(s -> System.out.println("    " + s));

        //求差集
        Sets.SetView<String> result3 = Sets.difference(c, c2);
        System.out.println("-----");
        result3.forEach(s -> System.out.print("  " + s));
        System.out.println("------------");


        //对等差分的意思是，两个集合去除交集后再求合集
        System.out.println("------------");
        Sets.SetView<String> result4 = Sets.symmetricDifference(c, c2);
        result4.forEach(s -> System.out.print("  " + s));
        System.out.println("\n------------");

        Set<List<String>> result5 = Sets.cartesianProduct(c, c2);
        result5.forEach(s -> System.out.println(" " + s));
        System.out.println("\n------------");
        /**
         *  [.net, python]
         *  [.net, java]
         *  [.net, c]
         *  [c++, python]
         *  [c++, java]
         *  [c++, c]
         *  [c, python]
         *  [c, java]
         *  [c, c]
         */

        //求所有的子集
        Set<Set<String>> result6 = Sets.powerSet(c);
        result6.forEach(s -> System.out.println(" " + s));

        System.out.println("\n---------------------");
    }

    @Test
    public void test3() {


        HashSet<String> strings = Sets.newHashSet("sunyehao", "zhaoritian", "ken sun","");
        Iterable filter = Iterables.filter(strings, new predicate());
        filter.forEach(s -> System.out.println(s));

        Multiset<String> multiset=new HashMultiset<>();

    }

    static class predicate implements Predicate<String> {

        @Override
        public boolean apply(@Nullable String input) {
            if (input.indexOf("s") > -1)
                return true;
            else
                return false;
        }

        @Override
        public boolean test(@Nullable String input) {
            if (input.indexOf("s") > -1)
                return true;
            else
                return false;
        }

    }



}
