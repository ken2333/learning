package thread.chapter2;

/**
 * @author ken
 * @date 2019/10/29  23:11
 * @description  join表示当前线程等待t1线程执行完后,接下来再执行代码
 */
public class JoinTest {

    private  static  int count=0;
    public static  class R1 implements Runnable
    {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            for(int i=0;i<100000000;i++)
            {
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new R1(),"子线程");
        t1.start();
        //让当前线程等待指定的线程，这里就是让主线程等待子线程执行完毕后再往下面走
        t1.join();
        System.out.println(count);
    }

}
