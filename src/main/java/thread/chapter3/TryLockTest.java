package thread.chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2019/10/31  22:11
 * @description ReenterLock 有个api, tryLock 方法, 用于在指定的时间内获取锁,如果获取不到就放弃
 */
public class TryLockTest {

    public  static  class  R1 implements Runnable
    {
      static   ReentrantLock  lock=new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    Thread.sleep(6000);
                }
                else
                {
                    System.out.println("获取🔒失败!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //判断是否当前线程持有锁,如果是就释放锁
                if(lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new R1());
        Thread t2=new Thread(new R1());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
