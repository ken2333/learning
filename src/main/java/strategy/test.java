package strategy;

import org.junit.Test;

/**
 * @author ken
 * @date 2019/5/10  0:19
 * @description
 */
public class test {

    @Test
    public void test()
    {
        ContextStrategy contextStrategy=new ContextStrategy(new Discount(0.5));

        System.out.println(contextStrategy.getResult(300));

        ContextStrategy contextStrategy1=new ContextStrategy(new RetrunCash(500,100));

        System.out.println(contextStrategy1.getResult(500));
    }
}
