package thread.chapter2;

/**
 * @author ken
 * @date 2019/10/29  23:11
 * @description  yield表示谦让的意思，会把当前的线程的优先度调低，把机会给其他线程，但是不代表不参与cpu的竞争。
 */
public class YieldTest {

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
        //把主线程的优先度调低
        Thread.yield();
        System.out.println(count);
    }

}
