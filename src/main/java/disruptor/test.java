package disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ken
 * @date 2019/3/10  19:34
 * @description
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        PCDataFactory factory=new PCDataFactory();
        int buffersize=1024;
        Disruptor<PCData> dataDisruptor=new Disruptor<PCData>(factory,buffersize,service,ProducerType.MULTI,new BlockingWaitStrategy());
        dataDisruptor.handleEventsWithWorkerPool(new Consumer(),new Consumer(),
                new Consumer(),new Consumer());

        dataDisruptor.start();

        RingBuffer<PCData> ringBuffer=dataDisruptor.getRingBuffer();

        Producer producer=new Producer(ringBuffer);

        ByteBuffer byteBuffer=ByteBuffer.allocate(8);

        for (long l=0;true;l++)
        {
            byteBuffer.putLong(0,l);
            producer.pushData(byteBuffer);
            Thread.sleep(100);
            System.out.println("add data:"+l);


        }
    }
}
