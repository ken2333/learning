package datetime;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * @author ken
 * @date 2019/5/27  0:29
 * @description
 */
public class TimeClassTest {

    @Test
    public void test()
    {
        Instant now = Instant.now();
        //获取时间戳
        System.out.println(now.toEpochMilli());
        System.out.println(now.getNano());
    }

    @Test
    public void test2()
    {
        //计算
        //自带的解析 若需要自定义格式，可以这么来
        Instant temp =Instant.parse("2007-12-03T10:15:30.00Z");

        Instant now = Instant.now();
        //在原有的基础上加上25个小时
        Instant instant = now.plusSeconds(TimeUnit.HOURS.toSeconds(25));

        //希望得到两个时间戳，他们相隔了几个小时、几天、几个月？
        System.out.println(now.until(instant, ChronoUnit.HOURS)); //25
        System.out.println(temp.until(now, ChronoUnit.DAYS)); //25
        System.out.println(now.until(instant,ChronoUnit.DAYS)); //1（这里显示1不是2哦）
        System.out.println(instant.until(now,ChronoUnit.DAYS)); //-25（注意，这里是负数哦）
    }

    @Test
    public void test3()
    {
        Clock c1 = Clock.systemUTC(); //系统默认UTC时钟（当前瞬时时间 System.currentTimeMillis()）

//这么来会采用系统默认的时区
        Clock c2 = Clock.systemDefaultZone(); //系统默认时区时钟（当前瞬时时间）

//输出那两个能看到效果
        System.out.println(c1); //SystemClock[Z]  这个其实用得最多
        System.out.println(c1.instant().toEpochMilli()); //SystemClock[Z]  这个其实用得最多
        System.out.println(c2); //SystemClock[Asia/Shanghai]

//可以获取到和时区敏感的对象
        Clock c3 = Clock.system(ZoneId.of("Europe/Paris")); //巴黎时区
        Clock c5 = Clock.offset(c1, Duration.ofSeconds(2)); //相对于系统默认时钟两秒的时钟
        System.out.println(c3.millis());
    }

    @Test
    public void test4()
    {
        //设置指定的日期格式
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //获取当前的时间
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate.format(format));

        //设置指定的日期
        LocalDate of = LocalDate.of(2007, 10, 8);
        System.out.println(of.format(format));
    }

}
