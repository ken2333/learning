package disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author ken
 * @date 2019/3/10  19:29
 * @description
 */
public class Producer {

    private  final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb)
    {
        long next = ringBuffer.next();
        try {
            PCData pcData = ringBuffer.get(next);
            pcData.setValue(bb.getLong(0));
        }
        finally {
            ringBuffer.publish(next);
        }
    }

}
