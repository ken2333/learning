package thread.chapter3;

import java.util.concurrent.Semaphore;

/**
 * @author ken
 * @date 2018-12-13  0:17
 * @description
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(10);

        new Thread2(semaphore,5).start();
        new Thread2(semaphore,3).start();
        new Thread2(semaphore,7).start();


    }

}
class  Thread2 extends  Thread{

    private Semaphore semaphore;

    private int count;

    public Thread2(Semaphore semaphore, int count) {
        this.semaphore = semaphore;
        this.count = count;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire(count);
            System.out.println(Thread.currentThread().getName()+"获取了"+count+"信号量");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+"释放了"+count+"信号量");
            semaphore.release(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
