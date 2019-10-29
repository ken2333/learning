package Threand;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2018-12-8  15:26
 * @description
 */
public class th4 {
    private static Lock lock=new ReentrantLock();
    private static  int count=0;
    public  static  class  MyTask implements  Runnable
    {
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取锁！");
            for(int i=0;i<100;i++)
            {
                count++;
            }
            System.out.println(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+"释放锁！");
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleWithFixedDelay(new MyTask(),10,10,TimeUnit.SECONDS);


    }
}
