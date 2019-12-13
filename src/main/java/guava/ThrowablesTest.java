package guava;

import com.google.common.base.Throwables;

import java.sql.SQLException;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/13
 */
public class ThrowablesTest {

    private static void dosomething() throws Exception {
        throw new NullPointerException();
    }


    private static void dosomething2() throws Exception {
        try {
                dosomething();
        } catch (Throwable t) {
            //Throwables.propagateIfInstanceOf(t, NullPointerException.class);
            t.printStackTrace();
        }
        System.out.println("dosomething2");
    }


    public static void main(String[] args) throws Exception {

        try {
            ThrowablesTest.dosomething2();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, NullPointerException.class);
           throw   Throwables.propagate(t);
        }
        System.out.println("123321");


    }
}
