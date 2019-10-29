package Threand;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author ken
 * @date 2019/3/7  21:04
 * @description
 */
public class ExcecutorsTest {
    private static HashMap<Long,Integer> map=new HashMap<>();  //用于记录线程的完成次数
    public  static  class  runnable implements  Runnable
    {
        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            System.out.println(Thread.currentThread().getId());
            if (map.containsKey(id)) {
                Integer i = map.get(id);
                map.put(id,++i);
            }
            else
            {
                map.put(id,1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程数为10的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        runnable runnable=new runnable();
        //提交一百个任务给线程池
        for(int i=0;i<100;i++)
        {
             executorService.submit(runnable);
        }
        Thread.sleep(3000);
        System.out.println(map);
        //关闭线程池
        executorService.shutdown();
    }
}
