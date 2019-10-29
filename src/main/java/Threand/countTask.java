package Threand;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author ken
 * @date 2019/3/7  22:38
 * @description
 */
public class countTask extends RecursiveTask {

    //设置界限
    private  static  final  int thershole=10000;
    //开始和结束
    private long start;
    private long end;

    public countTask(long start, long end) {
        this.start = start;
        this.end = end;
    }



    protected Long compute() {

        long sum=0;
    //若果end和start的间隔小于10000直接计算
        boolean canCompute=(end-start)<thershole;
        if(canCompute)
        {
            for(long i=start;i<=end;i++)
            {
                sum+=i;
            }
        }
        else
        {
            //分成100份
            long  step=(end-start)/100;
            //存储100个计算的结果
            ArrayList<countTask> arr=new ArrayList<>();
            long pos=start;
            for(int i=0;i<100;i++)
            {
                long last=(pos+step);
                if(last>end)
                {
                    last=end;
                }
                countTask task=new countTask(pos,last);
                //计算下一个开始
                pos+=step+1;
                //添加把任务添加到队列中
                arr.add(task);
                //执行分支的任务
                task.fork();
            }
            for(countTask tem:arr)
            {
                sum+= (Long)tem.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        //计算0，到20000的累加
        countTask task=new countTask(0,20000);
        //提交任务
        ForkJoinTask<Long> submit = pool.submit(task);
        try {
            //获取结果
            Long aLong = submit.get();
            System.out.println(aLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
