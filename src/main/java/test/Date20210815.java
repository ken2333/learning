package test;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * describe:
 *
 * @author syh
 * @date 2021/08/15
 */
public class Date20210815 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Object[] objects =  list.toArray();
        for (Object object : objects) {
            if(object instanceof  Integer)
            {
                System.out.println(object);
            }
        }
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> ints = Arrays.asList(arr);


    }
}
