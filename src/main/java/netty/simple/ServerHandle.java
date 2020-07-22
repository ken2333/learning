package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
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

    /**  ChannelHandlerContext 是上下文对象，包含管道pipeline ,channel
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        //把数据转化成string
        String s = byteBuf.toString(CharsetUtil.UTF_8);
        Channel channel = ctx.channel();
        SocketAddress socketAddress = channel.remoteAddress();
        System.out.println("来自客户端" + socketAddress.toString() + "的信息：" + s);
        //提交任务到任务列表中
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(10000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello client  ,finishi task", CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        ctx.channel().eventLoop().schedule(() -> {

            System.out.println("循环事件！");
        }, 2, TimeUnit.SECONDS);

    }

    //读取数据完毕后,返回一个数据给客户端
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
       ctx.writeAndFlush(Unpooled.copiedBuffer("已收到信息！".getBytes(CharsetUtil.UTF_8)));

    }

    //当遇到异常时
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭
        ctx.close();
        cause.printStackTrace();
    }
}
