package guava;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.*;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/11
 */
public class conllectionTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("你好");
        list.add("1233211");
        list.add("1233211");
        ImmutableSet set = ImmutableSet.of(list);
        ImmutableList<String> list1 = ImmutableList.copyOf(list);
        ImmutableMultiset<String> multiset = ImmutableMultiset.copyOf(list);
        System.out.println(multiset.size());
        UnmodifiableIterator<String> iterator = multiset.iterator();
        while (iterator.hasNext()) {
            String tem = iterator.next();
            System.out.println(tem);
        }
        int count = multiset.count("你好");
        System.out.println(count);
    }

    @Test
    public void test2() {

        HashMultimap <String, String> multimap= HashMultimap.create();
        multimap.put("a","1");
        multimap.put("a","2");
        multimap.put("a","3");
        Collection<String> a = multimap.get("a");
        Iterator<String> iterator = a.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
