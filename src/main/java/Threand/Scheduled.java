package Threand;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ken
 * @date 2019/3/7  21:28
 * @description
 */
public class Scheduled {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        System.out.println(System.currentTimeMillis());
        service.scheduleWithFixedDelay(()->{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis()); }
        ,1,2,TimeUnit.SECONDS);
    }
}
