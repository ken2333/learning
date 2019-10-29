package lamdba;

/**
 * @author ken
 * @date 2019/3/10  12:56
 * @description
 */
public class test2   {

    public void test(test test)
    {
        String name = test.getClass().getCanonicalName();
        System.out.println(name);
        test.handle();
    }
    public static  String say()
    {
        System.out.println("调用静态方法!");
        return "123";
    }
    public static void main(String[] args) {
        test2 test3=new test2();
        test3. test(()->{
            Runnable say = test2::say;
        });
    }
}
