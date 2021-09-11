package thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * describe:用lockInterruptibly()时，在等待获取锁的时候，如果线程触发了
 * Thread.interrupt()方法，就会报一个InterruptedException，之后取消锁的申请，
 * 同时也会释放已经获取的锁。
 *
 * @author syh
 * @date 2020/08/13
 */
public class ReetrerLockWithInterrupt implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    private int i;

    public ReetrerLockWithInterrupt(int i) {
        this.i = i;
    }

    @Override
    public void run() {

        try {
            switch (i) {
                case 1: {
                    lock1.lockInterruptibly();
                    Thread.sleep(500);
                    lock2.lockInterruptibly();
                    System.out.println("1"+"执行完毕");
                    break;
                }
                case 2: {
                    lock2.lockInterruptibly();
                    Thread.sleep(500);
                    lock1.lockInterruptibly();
                    System.out.println("2"+"执行完毕");
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //判断是否由当前的线程持有锁
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReetrerLockWithInterrupt t1 = new ReetrerLockWithInterrupt(1);
        ReetrerLockWithInterrupt t2 = new ReetrerLockWithInterrupt(2);

        Thread thread = new Thread(t1);
        Thread thread2 = new Thread(t2);

        //启动线程
        thread.start();
        thread2.start();
        Thread.sleep(2000);
        //中断线程
        thread2.interrupt();
    }

}
