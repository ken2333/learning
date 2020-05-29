package test;

import org.junit.Test;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author ken
 * @date 2019/5/23  23:23
 * @description
 */
public class test2 {
    public static void main(String[] args) {
            int i=1|4;
        System.out.println(i);
        System.out.println( 1 << 2);


        try {
            String s=null;
            Assert.notNull(s,"不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(123321);

    }

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //转化成日期字符串
        String date = simpleDateFormat.format(calendar.getTime());
        System.out.println(date);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }
    @Test
    public void test2() {
        ArrayList<String> strings=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            strings.add("a"+i);
        }
        String []strings1=new String[strings.size()];
        strings.toArray(strings1);
        for (String s : strings1) {
            System.out.println(s);
        }
        
    }
    @Test
    public void test3() {

    }
}
