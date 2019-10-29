package Threand;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2018-12-8  11:09
 * @description
 */
public class th2 {

    private static Lock lock=new ReentrantLock();

    private static  int count=0;
    static class consumer  {

        public void action(int i)
        {
            try {
                lock.lock();
                System.out.println("消费者获取线程");
                if(count>i)
                count-=i;
                else
                {
                    System.out.println("数量不足");
                }
                System.out.println("消费者解锁线程");
            } finally {
                lock.unlock();
            }
        }
    }

   static   class  productor
    {

        public void action(int i)
        {
            lock.lock();
            System.out.println("生产者获取线程");
            count+=i;
            System.out.println("生产者释放锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        consumer c=new consumer();
        productor p=new productor();
        p.action(211);
        c.action(200);
        Thread.currentThread().join(1000);
        System.out.println("剩余"+count);

    }
}
