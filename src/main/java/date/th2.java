package date;

import org.joda.time.DateTime;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

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

    @Test
    public void test2() throws ParseException {
        String expiredate="2020-01-30";
        int expireday=1;
        String result = "0";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse( expiredate + " 23:59:59");
        long day1 = date.getTime();
        long day2 = date1.getTime();
        long betweenday =  (day2 - day1) / 86400000;
        if (day2 - day1 < 0L && betweenday == 0) {
            betweenday = -1;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        if (betweenday >= 0 && betweenday <=  expireday) {
            result = "系统服务将于" + betweenday + "天后到期（" + calendar.get(1) + "年" + (calendar.get(2) + 1) + "月" + calendar.get(5) + "日" + "）届时将无法登录系统，请联系管理员尽快处理!";
        } else if (betweenday >  expireday) {
            result = "1";
        }
        System.out.println(result);
    }

    @Test
    public void test3() {
        LocalTime localTime=LocalTime.now();
        LocalTime parse = LocalTime.parse("22:00", DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(parse.getHour());
        System.out.println(parse.getMinute());
        System.out.println(parse.compareTo(localTime));
    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
        Date parse = simpleDateFormat.parse("22:00");
        System.out.println(parse.getHours());
        System.out.println(parse);

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR,20);
        Calendar now=Calendar.getInstance();
        System.out.println(instance.compareTo(now));
        System.out.println(instance.getTimeZone());
    }

    @Test
    public void test5() {
        String date="2019-11";
        String[] split = date.split("-");
        Calendar instance = Calendar.getInstance();
        instance.set( Integer.parseInt(split[0]),Integer.parseInt(split[1]),1);
        instance.set(Calendar.MONTH,Integer.parseInt(split[1]));
        System.out.println(instance.toString());
        System.out.println(instance.getTime().toLocaleString());
    }
}
