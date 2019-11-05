package thread.chapter3;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ken
 * @date 2019/11/5  23:36
 * @description
 */
public class concurentUtilsTest {
    private static ConcurrentSkipListMap<String, Integer> listMap = new ConcurrentSkipListMap<>();

    private static class R1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                String vale = String.valueOf(i);
                if (listMap.containsKey(vale)) {
                    int count = listMap.get(vale);
                    listMap.put(vale, count+1);
                }else
                {
                    listMap.put(vale, 0);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        R1 r1=new R1();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++)
        {
            executorService.submit(new R1());
        }
        Thread.sleep(20000);
        System.out.println(listMap.size());
        executorService.shutdown();
    }

}
