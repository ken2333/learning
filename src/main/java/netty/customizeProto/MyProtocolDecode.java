package netty.customizeProto;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.apache.commons.codec.Charsets;

import java.util.List;

/**
 * describe: 自定义解码器
 *
 * @author syh
 * @date 2020/08/04
 */
public class MyProtocolDecode extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int length = in.readInt();

        byte[] bytes = new byte[length];
        ByteBuf byteBuf = in.readBytes(bytes);
        MyProtocol myProtocol = new MyProtocol(length, bytes);
        out.add(myProtocol);
    }
}
