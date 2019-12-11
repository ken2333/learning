package date;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ken
 * @date 2018-11-24  16:43
 * @description
 */
public class th1 {

    @Test
    public void test()
    {
        LocalDate localDate =LocalDate.parse("1995-01-12",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate of = LocalDate.of(2019, 12, 11);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.atTime(12,12));
        LocalDate date1=LocalDate.of(1992,12,3);
        LocalDate date2=LocalDate.of(1992,12,3);
        System.out.println(date1.equals(date2));
        Clock clock=Clock.systemUTC();
        Clock clock2=Clock.systemDefaultZone();
        LocalDateTime dateTime=LocalDateTime.now(clock);
        LocalDateTime dateTime2=LocalDateTime.now(clock2);
        System.out.println("-------------->"+dateTime.equals(dateTime2));
        System.out.println("------------"+dateTime.toString());
        System.out.println("------------"+dateTime2.toString());
        System.out.println(clock.getZone());
    }
}
