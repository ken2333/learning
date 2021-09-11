package thread.chapter2;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/13
 */
public class VolatileTest {

    public static boolean ready = false;
    public static String number = "123";


    public static class  ReaderThread extends  Thread{
        @Override
        public void run() {
            while(!ready)
            {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest.ReaderThread readerThread = new VolatileTest.ReaderThread();
        readerThread.start();
        Thread.sleep(1000);
        VolatileTest.ready = true;
        Thread.sleep(1000);
    }

}
