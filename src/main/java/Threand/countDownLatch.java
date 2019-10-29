package Threand;

import java.util.concurrent.CountDownLatch;

/**
 * @author ken
 * @date 2019/3/6  22:24
 * @description 计时锁
 */
public class countDownLatch {

     private static CountDownLatch count=new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads=new Thread[10];
        for(int i=0;i<threads.length;i++)
        {
            threads[i]=new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"倒计时-1   "+count.getCount());
            count.countDown();});
            threads[i].start();
        }
        count.await();
        System.out.println("开始执行");
    }
}
