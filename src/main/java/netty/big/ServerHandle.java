package netty.big;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.FileInputStream;
import java.net.SocketAddress;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ServerHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        String path = "E:\\supports\\linux\\deepin-15.10.1-amd64.iso";
        File file = new File(path);
        FileInputStream in = new FileInputStream(file); // 创建一个FileInputStream
        FileRegion region = new DefaultFileRegion(in.getChannel(), 0, // 以该文件的完整长度创建一个新的DefaultFileRegion
                file.length());
        channel.writeAndFlush(region).addListener(
                new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            Throwable cause = future.cause();// 处理失败
                            // Do something
                        }
                    }
                });
    }

    //读取数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        //把数据转化成string
        String s = byteBuf.toString(CharsetUtil.UTF_8);
        Channel channel = ctx.channel();
        SocketAddress socketAddress = channel.remoteAddress();
        System.out.println("来自客户端" + socketAddress.toString() + "的信息：" + s);

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
