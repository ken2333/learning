package netty.customizeProto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.apache.commons.codec.Charsets;

import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ClientHandle extends SimpleChannelInboundHandler<MyProtocol> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtocol msg) throws Exception {
        byte[] data = msg.getData();
        String tem = new String(data, Charsets.UTF_8);
        System.out.println("客户端收到消息：" + tem);
    }

    //在通道可以就绪时出发这方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        byte[] bytes = "你好啊".getBytes(Charsets.UTF_8);
        for (int i = 0; i < 10; i++) {
            MyProtocol myProtocol = new MyProtocol(bytes.length, bytes);
            ctx.writeAndFlush(myProtocol);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
