package Threand;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2018-12-8  10:39
 * @description 重入锁
 */
public class th1 {

    private static int count = 0;

    public static class Thread1 implements Runnable {
        public ReentrantLock lock = null;

        public Thread1(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得锁");
            for(int i=0;i<1000;i++)
            {
                count++;
            }
            System.out.println(Thread.currentThread().getName()+"释放锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock=new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread1 thread1 = new Thread1(lock);
        Thread thread[]=new Thread[20];
        for(int i=0;i<20;i++)
        {
            thread[i]=new Thread(thread1);
        }
        for(int i=0;i<20;i++)
        {
            thread[i].start();
        }
        Thread.currentThread().join(2000);
        System.out.println(count);



    }
}
