package thread.chapter3;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/16
 */
public class ExecutorsTest {

    public static class RunnableImpl implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "执行任务！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {

        //创建拥有5个线程的线程池。
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new RunnableImpl());
            //提交任务
            executorService.submit(threads[i]);
        }
        Thread.sleep(2000);
    }


    @Test
    public void test2() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        //提交任务在5秒后执行
        scheduledExecutorService.schedule(new RunnableImpl(), 4, TimeUnit.SECONDS);
        Thread.sleep(6000);

    }


}



