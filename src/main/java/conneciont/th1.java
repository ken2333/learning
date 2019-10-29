package conneciont;

import Json.Student;
import org.apache.commons.collections4.ArrayStack;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BagUtils;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @author ken
 * @date 2018-11-26  18:53
 * @description
 */
public class th1 {

    @Test
    public void test()
    {
        ArrayStack<String> stack=new ArrayStack();
        stack.push("sun");
        stack.add("ye");
        stack.add("hao");
        System.out.println(stack.size());
        while (!stack.isEmpty())
        {
            String pop = stack.pop();
            System.out.println(pop);
        }

    }
    @Test
    public void test2()
    {
        //包
       /* Bag<String> bag=new HashBag<>();
        bag.add("a");
        bag.add("a");
        bag.add("a");
        bag.add("v");
        bag.add("b");
        bag.add("b");
        bag.add("b");
        bag.add("c");
        bag.add("c");
        Set<String> strings = bag.uniqueSet();
        for(String str:strings)
        {
            System.out.println(str);
        }
        System.out.println(bag.getCount("a"));
        Bag<String> bag1 = BagUtils.collectionBag(bag);
        System.out.println(bag1.toArray());

        Student student=new Student("小明","12");
        Student student2=new Student("小明","12");*/

    }
}
