package netty.echoServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.CharSet;

/**
 * @author ken
 * @date 2019/3/8  16:06
 * @description
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /*对于每个传入的消息都要处理*/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       ByteBuf in= (ByteBuf) msg;
        System.out.println("server received"+in.toString(Charsets.UTF_8));
        ctx.write(msg);
    }

    /*调用是当前批量读取中的最后一条消息*/

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    /* 在读取操作期间，有异常抛出时会调用*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
