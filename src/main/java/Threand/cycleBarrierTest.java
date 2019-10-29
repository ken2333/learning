package Threand;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ken
 * @date 2018-12-12  0:53
 * @description
 */
public class cycleBarrierTest {

    private static CyclicBarrier cb;

    public static void main(String[] args) {
        cb=new CyclicBarrier(5);
        for(int i=0;i<5;i++)
        {
            new Thread(new run()).start();
        }
    }

    public static  class  run implements  Runnable
    {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"开始执行!");
            try {
                //开始等待
                cb.await();
                System.out.println(Thread.currentThread().getName()+"继续执行!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
