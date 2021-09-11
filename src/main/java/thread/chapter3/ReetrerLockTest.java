package thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2019/10/31  21:53
 * @description 重入锁的测试案例
 * <p>
 * 重入锁表示一个线程可以连续获取锁多次而不会死锁, 记住几把锁就要释放几把锁,
 * 否则会出现异常.
 * 例如:
 * lock.lock()
 * lock.lock()
 * dosomethind()....
 * <p>
 * lock.unlock();
 * lock.unlock();
 */
public class ReetrerLockTest {

    public static class R1 implements Runnable {
        public static ReentrantLock lock = new ReentrantLock();
        public static int count = 0;

        @Override
        public void run() {
            //加锁
            lock.lock();
            for (int i = 0; i < 100000; i++) {
                count++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new R1());
        Thread t2 = new Thread(new R1());

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("结果：" + R1.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
