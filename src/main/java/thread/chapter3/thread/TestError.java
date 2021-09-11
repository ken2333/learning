package thread.chapter3.thread;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe: 测试submit和execute的区别
 *
 * @author syh
 * @date 2020/08/16
 */
public class TestError {

    private static class RunnableImpl implements Runnable {
        private int x;
        private int y;

        public RunnableImpl(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            System.out.println(x / y);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new RunnableImpl(1, 2));
        executorService.submit(new RunnableImpl(2, 1));
        executorService.submit(new RunnableImpl(4, 2));
        executorService.submit(new RunnableImpl(1, 0));
        executorService.submit(new RunnableImpl(11, 1));

        Thread.sleep(1000);
    }


    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new RunnableImpl(1, 2));
        executorService.execute(new RunnableImpl(2, 1));
        executorService.execute(new RunnableImpl(4, 2));
        executorService.execute(new RunnableImpl(1, 0));
        executorService.execute(new RunnableImpl(11, 1));

        Thread.sleep(1000);
    }

}
