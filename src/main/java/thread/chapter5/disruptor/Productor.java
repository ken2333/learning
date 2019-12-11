package thread.chapter5.disruptor;

import com.lmax.disruptor.RingBuffer;
import jxl.biff.RangeImpl;

import java.nio.ByteBuffer;

/**
 * describe: 生产者
 *
 * @author syh
 * @date 2019/11/12
 */
public class Productor {

    private  final RingBuffer<PCData> ringBuffer;

    public Productor(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void  pushData(ByteBuffer byteBuffer)
    {
        long next = ringBuffer.next();

        PCData pcData = ringBuffer.get(next);
        pcData.setData(byteBuffer.getLong(0));

        ringBuffer.publish(next);
    }
}
