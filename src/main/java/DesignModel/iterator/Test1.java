package DesignModel.iterator;

import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/07
 */
public class Test1 {

    @Test
    public void test() {
        ConcreteMyAggregate<String> aggregate=new ConcreteMyAggregate();
        aggregate.add("string");
        aggregate.add("integer");
        aggregate.add("boolen");
        MyIterater iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(iterator.next());

        }

    }
}
