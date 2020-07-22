package netty.beyteBuffe;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class Example {

    @Test
    public void test() {
        //创建buteBuf
        ByteBuf byteBuf = Unpooled.buffer(20);

        for(int i=0;i<10;i++)
        {
            byteBuf.writeByte(i);
        }

        for (int i = 0; i < byteBuf.writerIndex(); i++) {
            System.out.println(byteBuf.readByte());
            
        }

    }
}
