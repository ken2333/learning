package client;

import fe.dao.Dao;
import fe.dao.DataTable;
import fe.dao.FieldSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ken
 * @date 2019-4-18  13:55
 * @description
 */
public class WorkDay {

    /**
     * <p>Title: main </P>
     * <p>Description: TODO </P>
     *
     * @param args return void    返回类型
     *             throws
     *             date 2014-11-24 上午09:11:47
     */
    public static void main(String[] args) {
        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            Date d = df.parse("2019-4-18");
            ca.setTime(d);//设置当前时间

            WorkDay ct = new WorkDay();
            ct.initHolidayList("2019-4-22");//初始节假日
            ct.initHolidayList("2019-4-23");//初始节假日


            Calendar c = ct.addDateByWorkDay(ca, 4);
            System.out.println(df.format(c.getTime()));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getClass());
            e.printStackTrace();
        }

    }


    public Dao dao;

    private static String tableName = "VACATIONS";

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    //private static List<Calendar> holidayList = new ArrayList<Calendar>();  //节假日列表
    private static DataTable dbtable = null;

    /**
     * <p>Title: addDateByWorkDay </P>
     * <p>Description: TODO  计算相加day天，并且排除节假日和周末后的日期</P>
     *
     * @param calendar 当前的日期
     * @param day      相加天数
     * @return return Calendar    返回类型   返回相加day天，并且排除节假日和周末后的日期
     * throws
     * date 2014-11-24 上午10:32:55
     */
    public Calendar addDateByWorkDay(Calendar calendar, int day) {

        try {
            for (int i = 0; i < day; i++) {

                calendar.add(Calendar.DAY_OF_MONTH, 1);

                if (checkHoliday(calendar)) {
                    i--;
                }
            }
            return calendar;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * <p>Title: checkHoliday </P>
     * <p>Description: TODO 验证日期是否是节假日</P>
     *
     * @param calendar 传入需要验证的日期
     * @return return boolean    返回类型  返回true是节假日，返回false不是节假日
     * throws
     * date 2014-11-24 上午10:13:07
     */
    public boolean checkHoliday(Calendar calendar) throws Exception {

        //返回数据的数量
        int count = dbtable != null ? dbtable.getRow() : 0;
        //若有节假日，就和传入的日期遍历比较
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                FieldSet tem = dbtable.getData(i);
                Calendar ca = initHolidayList(tem.getString("VA01"));
                //应为有调休日，所以并不是所有的节假日都是休息日，要进行判断
                boolean isholiday = tem.getString("VA03").equals("true");
                if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                        ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
                        ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                    if (isholiday)
                        return true;
                    else
                        return false;
                }
            }
        }
        //判断日期是否是周六周日
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return true;
        }
        return false;
    }

    /**
     * <p>Title: initHolidayList </P>
     * <p>Description: TODO  把所有节假日放入list</P>
     *
     * @param date 从数据库查 查出来的格式2014-05-09
     *             return void    返回类型
     *             throws
     *             date 2014-11-24 上午10:11:35
     */
    public Calendar initHolidayList(String date) {

        String[] da = date.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
        calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);//月份比正常小1,0代表一月
        calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
        return calendar;
    }


    /*
    * 获取今天后的workday个工作日的日期。
    * */
    public String initHolidayList(int workday) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月份的1号
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String date1 = simpleDateFormat.format(calendar.getTime());

        //获取下一个月的月尾
        calendar.add(Calendar.MONTH, 2);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String date2 = simpleDateFormat.format(calendar.getTime());
        DataTable fieldSetByFilter = dao.getDataTable(tableName, " VA01 BETWEEN  '" + date1 + "' and '" + date2 + "'");

        dbtable = fieldSetByFilter;

        //获取当前日期，得到三个工作日后的日期。
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar1 = addDateByWorkDay(calendar2, workday);
        String result = simpleDateFormat.format(calendar1.getTime());
        return result;

    }


}
