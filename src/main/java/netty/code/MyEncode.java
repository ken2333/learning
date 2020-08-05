package netty.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.commons.codec.Charsets;

import java.util.List;

/**
 * describe: 自定义的解码器
 *
 * @author syh
 * @date 2020/08/03
 */
public class MyEncode extends MessageToByteEncoder<String> {


    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        out.writeBytes(msg.getBytes(Charsets.UTF_8));
    }
}
