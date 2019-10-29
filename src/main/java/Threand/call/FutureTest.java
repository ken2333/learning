package Threand.call;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

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
}
