package Json;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/15
 */
public class GsonTest {

    @Test
    public void test() {
        Gson gson=new Gson();
        Student student = gson.fromJson("{\"id\":\"1\",\"name\":\"sun\"}", Student.class);
        System.out.println(student.toString());
    }
}
