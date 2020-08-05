package netty.customizeProto;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/04
 */
public class MyProtocolEncoder extends MessageToByteEncoder<MyProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MyProtocol msg, ByteBuf out) throws Exception {
        //获取长度,并写入长度的数据
        int length = msg.getLength();
        out.writeInt(length);
        //获取数据，写入数据
        byte[] data = msg.getData();
        out.writeBytes(data);
    }
}
