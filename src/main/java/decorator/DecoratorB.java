package decorator;

import decorator.Decorator;

/**
 * @author ken
 * @date 2019/5/10  23:37
 * @description
 */
public class DecoratorB extends Decorator {


    @Override
    public void show() {
        person.show();
        System.out.println("穿衣服B");
    }
}
