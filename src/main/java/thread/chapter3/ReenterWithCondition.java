package thread.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/13
 */
public class ReenterWithCondition implements  Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    //获取conditioon
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("进行等待");
            //进行等待，同时是否锁
            condition.await();
            System.out.println("开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterWithCondition reenterWithCondition = new ReenterWithCondition();
        Thread thread = new Thread(reenterWithCondition);
        thread.start();
        Thread.sleep(4000);
        try {
            //获取锁
            lock.lock();
            //唤醒之前在等待的线程
            condition.signal();
        } finally {
            //释放锁
            lock.unlock();
        }

    }
}
