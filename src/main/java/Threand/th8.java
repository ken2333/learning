package Threand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ken
 * @date 2019/3/7  22:12
 * @description
 */
public class th8 {
    private  static  class runnable implements Runnable
    {
        private int a;
        private int b;

        public runnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            System.out.println(a/b);
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new runnable(14,2));
        executorService.execute(new runnable(3,1));
        executorService.execute(new runnable(12,2));
        executorService.execute(new runnable(12,0));

    }
}
