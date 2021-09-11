package thread.chapter3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/15
 */
public class CycleBarrierTest {

    public static class Soldier implements Runnable {

        //循环计时器
        private CyclicBarrier cyclicBarrier;

        public Soldier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                System.out.println(name + "，开始集合！");
                cyclicBarrier.await();
                System.out.println(name + "，完成了集合！");
                cyclicBarrier.await();
                System.out.println(name + "，开始工作！");
                Thread.sleep(2000);
                System.out.println(name + "，完成了工作！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("执行完毕！");
        });
        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread(new Soldier(cyclicBarrier));
            threads[i] = thread;
            thread.start();
        }
        for (Thread thread : threads) {
            if (thread != null) {
                thread.join();
            }
        }
    }
}
