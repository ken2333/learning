package thread.chapter3;

import java.util.concurrent.Semaphore;

/**
 * @author ken
 * @date 2018-12-13  0:17
 * @description
 */
public class SemaphoreTest2 {

    private  static  Semaphore semaphore=new Semaphore(10);

    public static  class  runnable implements  Runnable
    {
        @Override
        public void run() {
            try {
                semaphore.acquire(4);
                System.out.println(Thread.currentThread().getName()+"获取消息量");
                Thread.sleep(10000);
                semaphore.release(4);
                System.out.println(Thread.currentThread().getName()+"释放消息量");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Runnable runnable=new runnable();
        Thread thread=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        Thread thread3=new Thread(runnable);
        thread.start();
        thread2.start();
        thread3.start();

    }


}
