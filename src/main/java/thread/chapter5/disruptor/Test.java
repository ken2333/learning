package thread.chapter5.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe:
 *
 * @author syh
 * @date 2019/11/12
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        PCDataFatory fatory=new PCDataFatory();
        int bufferSize=1024;
        Disruptor<PCData> dataDisruptor=new Disruptor<PCData>(fatory,bufferSize,executorService, ProducerType.MULTI,new BlockingWaitStrategy());

        dataDisruptor.handleEventsWithWorkerPool(new Comsumer(),new Comsumer());

        dataDisruptor.start();

        RingBuffer<PCData> ringBuffer=dataDisruptor.getRingBuffer();

        Productor productor=new Productor(ringBuffer);

        ByteBuffer byteBuffer=ByteBuffer.allocate(8);

        for(long i=0;i<1024;i++)
        {
            byteBuffer.putLong(0,i);
            productor.pushData(byteBuffer);
            String name = Thread.currentThread().getName();
            System.out.println(name+"系统增加"+i);
        }

    }
}
