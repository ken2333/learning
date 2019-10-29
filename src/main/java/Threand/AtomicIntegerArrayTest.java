package Threand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author ken
 * @date 2019/3/9  17:42
 * @description
 */
public class AtomicIntegerArrayTest {

    private  static AtomicIntegerArray array=new AtomicIntegerArray(10);
    private  static class runnable implements  Runnable
    {
        private int i;

        public runnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {

            array.incrementAndGet(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int k=0;k<10;k++)
        {
            for(int j=0;j<1000;j++)
            {
                executorService.execute(new runnable(k));
            }
        }
        Thread.sleep(2000);
        System.out.println(array);
        executorService.shutdown();
    }
}
