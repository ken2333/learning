package thread.chapter4;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author ken
 * @date 2019/11/9  23:25
 * @description
 */
public class AtomicTest3 {

    private  static  class  R1 implements  Runnable{
       private AtomicIntegerArray array;

        public R1(AtomicIntegerArray array) {
            this.array = array;
        }

        @Override
        public void run() {

            for(int i=0;i<10000;i++)
            {
                //获取并且加1，不断的在数组内循环0-9
                array.incrementAndGet(i%array.length());
            }
        }

        public static void main(String[] args) {
            AtomicIntegerArray array = new AtomicIntegerArray(10);
            Thread [] threads=new Thread[10];
            for (int  i=0;i<10;i++)
            {
                threads[i]=new Thread(new R1(array));
            }
            for (int  i=0;i<threads.length;i++)
            {
                threads[i].start();
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(array);
        }
    }
}
