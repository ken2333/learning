package Threand;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2019/3/6  16:15
 * @description
 */
public class condiction {

    private static ReentrantLock lock=new ReentrantLock();

    private static Condition condition=lock.newCondition();


    public static  class  runable implements  Runnable
    {
        @Override
        public void run() {
                lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取锁");
            try {
                System.out.println(Thread.currentThread().getName()+"进行等待状态");
                condition.signal();
                condition.await(2,TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName()+"重新进行如执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放锁");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread []threads=new Thread[10];
        for(int i=0;i<10;i++)
        {
            threads[i]=new Thread(new runable());
        }
        for(int i=0;i<10;i++)
        {
            threads[i].start();
        }
         Thread.sleep(2000);
        //condition.signal();

    }
}
