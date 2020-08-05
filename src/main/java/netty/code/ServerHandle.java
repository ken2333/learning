package netty.code;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ServerHandle extends ChannelInboundHandlerAdapter {


    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String s = (String) msg;
        Channel channel = ctx.channel();
        SocketAddress socketAddress = channel.remoteAddress();
        System.out.println("来自客户端" + socketAddress.toString() + "的信息：" + s);


    }

    //读取数据完毕后,返回一个数据给客户端
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
     //  ctx.writeAndFlush(Unpooled.copiedBuffer("已收到信息！".getBytes(CharsetUtil.UTF_8)));

    }

    //当遇到异常时
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭
        ctx.close();
        cause.printStackTrace();
    }
}
