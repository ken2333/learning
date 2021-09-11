package Threand;

import java.util.concurrent.CountDownLatch;

/**
 * @author ken
 * @date 2019/3/6  22:24
 * @description 计时锁
 */
public class countDownLatch {

    private static CountDownLatch count = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程数组，包含了10个线程
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                String name = Thread.currentThread().getName();
                //计数减一
                count.countDown();
                System.out.println(name + "倒计时-1   " + count.getCount());

                try {
                    //阻塞的位置
                    count.await();
                    System.out.println(name + "开始执行！");
                    Thread.sleep(1000);
                    System.out.println(name + "执行完毕！");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            //等待全部的线程执行完毕
            thread.join();
        }
        System.out.println("全部执行完毕！");
    }
}
