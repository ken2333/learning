package protectedTest.same;

/**
 * describe:
 *
 * @author syh
 * @date 2021/08/14
 */
public class Son extends  Father {

    @Override
    protected void test() {
        System.out.println("调用了子类的方法");
    }
}
