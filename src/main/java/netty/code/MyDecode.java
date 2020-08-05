package netty.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * describe: 自定义的解码器
 *
 * @author syh
 * @date 2020/08/03
 */
public class MyDecode extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        String s = in.toString(Charsets.UTF_8);
        //由于之前的toString()方法不会修改butebuf的readIndex，所以需要手动的设置readIndex，防止循环读取
        in.readerIndex(in.readableBytes());
        System.out.println("触发解码：" + s);
        if (StringUtils.isNotBlank(s)) {
            out.add(s);
        }
    }
}
