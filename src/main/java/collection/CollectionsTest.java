package collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * describe:
 *
 * @author syh
 * @date 2021/08/16
 */
public class CollectionsTest {

    @Test
    public void test() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(199);
        integers.add(22);
        integers.add(33);
        integers.add(11);

        Collections.sort(integers, (o1, o2) -> {
            if (o1 > o2)
                return 1;
            else if (o1 < o2)
                return -1;
            else
                return 0;
        });

        integers.forEach(item -> System.out.println(item));



    }

}
