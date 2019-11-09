package thread.chapter4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ken
 * @date 2019/11/9  22:08
 * @description
 */
public class AtomicTest {

    private static class R1 implements Runnable {
        AtomicReference<Integer> num;

        public R1(AtomicReference<Integer> i) {
            this.num = i;
        }

        @Override
        public void run() {
            boolean flag = true;
            while (flag) {
                Integer integer = num.get();
                //放入期待值和修改后的值，如果修改失败了，证明有其他的线程先修改了值
                // 这时会返回false,这样直到修改成功退出序列
                boolean b = num.compareAndSet(integer, integer + 1);
                if (b)
                    flag = false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建固定的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //初始化值
        AtomicReference<Integer> integerAtomicReference = new AtomicReference<>(0);
        for (int i = 0; i < 1000; i++) {
            //执行1000次任务
            executorService.execute(new R1(integerAtomicReference));
        }
        Thread.sleep(3000);
        //获取结束后的值
        System.out.println(integerAtomicReference.get());
        if (!executorService.isShutdown()) {
            executorService.shutdown();
            System.out.println("关闭");
        }

    }
}
