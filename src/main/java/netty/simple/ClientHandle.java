package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ClientHandle extends ChannelInboundHandlerAdapter {

    //在通道可以就绪时出发这方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送信息到服务器中
        ctx.channel().eventLoop().schedule(() -> {
            ctx.writeAndFlush(Unpooled.copiedBuffer("hello server, im client", CharsetUtil.UTF_8));
        }, 2, TimeUnit.SECONDS);

        ctx.channel().eventLoop().scheduleAtFixedRate(() -> {
            ctx.writeAndFlush(Unpooled.copiedBuffer("循环任务", CharsetUtil.UTF_8));
        },0,4, TimeUnit.SECONDS);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        String str = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("收到服务器的信息：" + str);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
