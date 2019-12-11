package thread.chapter5.disruptor;

/**
 * describe:
 *
 * @author syh
 * @date 2019/11/13
 */
public class T1 {

    private  static volatile  int i=0;

    private  static class R1 implements  Runnable
    {
        @Override
        public void run() {
            for(int j=0;j<10000;j++)
            {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread [] threads=new Thread[10];
        for(int k=0;k<threads.length;k++)
        {
            threads[k]=new Thread(new R1());
        }
        for(int k=0;k<threads.length;k++)
        {
            threads[k].start();
        }
        for(int k=0;k<threads.length;k++)
        {
            threads[k].join();
        }
        Thread.sleep(1000);
            System.out.println(i);
    }
}
