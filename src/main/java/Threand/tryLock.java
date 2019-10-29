package Threand;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2019/3/6  15:35
 * @description p75
 */
public class tryLock {
   private static ReentrantLock lock=new ReentrantLock();

    public  static  class Runnable1 implements  Runnable
    {

        @Override
        public void run() {
            try {
                if(lock.tryLock(5,TimeUnit.SECONDS))
                {
                    System.out.println(Thread.currentThread().getName()+"获取锁");
                    Thread.sleep(3000);
                }
                else
                {
                    System.out.println(Thread.currentThread().getName()+"获取锁失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                if(lock.isLocked())
                {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"解除锁");
                }
            }
        }
    }

        public static void main(String[] args) {
            Runnable1 tryLock=new Runnable1();
            Runnable1 tryLock2=new Runnable1();

            Thread thread=new Thread(tryLock);
            Thread thread2=new Thread(tryLock2);

            thread.start();
            thread2.start();
        }
}
