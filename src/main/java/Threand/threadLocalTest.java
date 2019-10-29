package Threand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ken
 * @date 2019/3/9  0:23
 * @description
 */
public class threadLocalTest {
    private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

    private  static  class  runnable implements  Runnable
    {
        private int i;

        public runnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            Date format = null;
            try {
                format = dateFormat.parse("1992-12-1");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(i+":"+format);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<1000;i++)
        {
            executorService.execute(new runnable(i));
        }
     if (!executorService.isShutdown())
     {
         executorService.shutdown();
     }
    }
}
