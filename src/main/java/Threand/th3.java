package Threand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2018-12-8  15:05
 * @description
 */
public class th3 {

    private static  int  count=0;

    private static ReentrantLock lock=new ReentrantLock(false);
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
            System.out.println(Thread.currentThread().getName()+"释放锁！");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;)
        {
            service.submit(new MyTask());
            i++;
        }
        Thread.currentThread().join(1000);
        System.out.println(count);
        service.shutdown();
    }
}
