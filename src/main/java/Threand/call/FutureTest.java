package Threand.call;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author ken
 * @date 2019/3/9  22:10
 * @description
 */
public class FutureTest {
    public static void main(String[] args) {
        FutureTask<String> realDataFutureTask=new FutureTask<String>(new RealData("app"));
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(realDataFutureTask);
        System.out.println("请求完毕");
            //其他的请求
        try {
            System.out.println(realDataFutureTask.get());
            System.out.println("其他的东西");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test()
    {
        FutureTask<String> test = new FutureTask<>(new RealData("test"));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(new RealData("123"));
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
