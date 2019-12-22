package date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/18
 */
public class th2 {

    @Test
    public void test() {
        DateTime yesterday = DateTime.now();
        DateTime dateTime = yesterday.minusDays(1);
        System.out.println(dateTime.toString("yyyy-MM-dd"));
    }
}
