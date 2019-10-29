package conneciont;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.junit.Test;

import java.util.*;

/**
 * @author ken
 * @date 2018-11-29  18:08
 * @description
 */
public class th2 {


    @Test
    /**/
    public void test() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("list2");
        list2.add("list2");
        list2.add("list2");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("list3");
        list3.add("list3");
        list3.add("list3");
        CollectionUtils.addAll(list, list2);
        CollectionUtils.addAll(list, "123", "324", "4567");
        for (String tem : list) {
            System.out.println(tem);
        }
        System.out.println("---------------->");
        for (String str : list) {
            System.out.println(str);
        }
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, "first");
        System.out.println(list.size());

    }

    @Test
    public void test3() {
        SortedSet<Integer> set = new TreeSet();
        set.add(12);
        set.add(5);
        set.add(14);
        set.add(6);
        SortedSet<Integer> set2 = new TreeSet();
        set2.add(7);
        set2.add(3);
        set2.add(5);
      /*  for(Integer tem:set)
        {
            System.out.println(tem);
        }*/
        List<Integer> collate = CollectionUtils.collate(set, set2);
        for (Integer tem : collate)
            System.out.println(tem);
        boolean b = CollectionUtils.containsAll(set, new HashSet<Integer>());
        System.out.println("result" + b);
        boolean b1 = CollectionUtils.containsAny(set, set2);
        System.out.println("result:" + b1);
    }

    @Test
    public void test4() {
        String[] arrayA = new String[]{"1", "2", "3", "3", "4", "5"};
        String[] arrayB = new String[]{"3", "4", "4", "5", "6", "7"};
        List<String> a = Arrays.asList(arrayA);
        List<String> b = Arrays.asList(arrayB);
        //求两个集合的交集
        Collection<String> disjunction = CollectionUtils.disjunction(a, b);
        for (String tem : disjunction) {
            System.out.println(tem);
        }
    }

    @Test
    public void test5() {
        Collection<Object> objects = CollectionUtils.emptyCollection();
        // boolean string = objects.add("string");
        //System.out.println(string);
        List<String> list = new ArrayList<>();
        list.add("123");
        Collection<String> strings = CollectionUtils.emptyIfNull(list);
        System.out.println(strings.size());
    }

    @Test
    public void test6() {
        ArrayList<String> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println(CollectionUtils.isFull(list));
        HashMap<String, String> map = new HashMap<>();
        //     System.out.println(CollectionUtils.exists(map,"1"));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("123");
        String s = CollectionUtils.extractSingleton(arrayList);
        System.out.println(s);
    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        System.out.println(CollectionUtils.sizeIsEmpty(list));
    }

    public static class MyPredicate implements Predicate {
        @Override
        public boolean evaluate(Object o) {
            Integer i = null;
            if (o == null) {
                throw new IllegalArgumentException("不能为空!");
            }
            if (!(o instanceof Integer)) {
                throw new IllegalArgumentException("类型不正确");
            } else
                i = (Integer) o;

            return i > 10;
        }
    }

    @Test
    public void test8() {
        List<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(4);
        list.add(123);
        list.add(43);
        list.add(14);
        list.add(9);
        boolean filter = CollectionUtils.filter(list, new AllPredicate<>());
        System.out.println(filter);
    }

    @Test
    public void test9()
    {
        List<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(4);
        list.add(123);
        list.add(43);
        list.add(14);
        list.add(9);
        List collection = ( List<Integer>)CollectionUtils.predicatedCollection(list, new MyPredicate());
        for(int i=0;i<collection.size();i++)
        {
            System.out.println(collection.get(i));
        }
    }

    @Test
    public void test10()
    {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("sun");
        arrayList.add("sun");
        arrayList.add("sun");
        arrayList.add("sun");
        int i = CollectionUtils.maxSize(arrayList);
        System.out.println(i);
    }
    @Test
    public void test11()
    {
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("sun1");
        arrayList.add("sun2");
        Collection<String> strings = CollectionUtils.predicatedCollection(arrayList,new AnyPredicate<String>());

    }
    @Test
    public void test12()
    {
        List<Integer> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(12);
        Collection<Integer> union = CollectionUtils.union(list, list2);
        for(Integer i:union)
        {
            System.out.println(i);
        }

    }
}
