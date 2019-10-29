package netty.echoServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import org.apache.commons.codec.Charsets;

/**
 * @author ken
 * @date 2019/3/8  16:06
 * @description
 */
public class EchoServerHandler2 extends ChannelOutboundHandlerAdapter {

    /*对于每个传入的消息都要处理*/

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf byteBuf=(ByteBuf) msg;
        Channel channel = ctx.channel();
        ChannelFuture channelFuture = ctx.writeAndFlush(byteBuf);
        if (channelFuture.isSuccess()) {
            
        }

    }
    /*调用是当前批量读取中的最后一条消息*/



    /* 在读取操作期间，有异常抛出时会调用*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
