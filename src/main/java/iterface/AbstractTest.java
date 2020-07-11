package iterface;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/18
 */
public abstract class AbstractTest implements Test {

    @Override
    public void method1() {
    }

    public  static void test() {
        System.out.println("test1");
    }



    public static void main(String[] args) {
        AbstractTest.test();
    }
}
