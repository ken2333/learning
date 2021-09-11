package thread.chapter3;

import org.eclipse.jetty.util.BlockingArrayQueue;

/**
 * describe: 测试BlockingQueue接口的实现类
 *
 * @author syh
 * @date 2020/08/16
 */
public class BlockingCollectionTest {

    private static BlockingArrayQueue<String> list = new BlockingArrayQueue<>();

    private static class ReaderImpl implements Runnable {

        @Override
        public void run() {
            while (true) {
                String poll = null;
                try {
                    //获取数据
                    poll = list.take();
                    System.out.println("弹出数据：" + poll);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class WriteImpl implements Runnable {

        private String string;

        public WriteImpl(String string) {
            this.string = string;
        }

        @Override
        public void run() {

                //塞入数据
                list.offer(string);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread read = new Thread(new ReaderImpl());
        read.start();


        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new WriteImpl("测试数据" + i));
            threads[i].start();
            
        }
        for (Thread thread : threads) {
            thread.join();
        }
        read.join();
    }

}
