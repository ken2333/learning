package netty.proto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import netty.proto.ob.StudentOb;

import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ServerHandle extends SimpleChannelInboundHandler<StudentOb.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentOb.Student msg) throws Exception {
        long id = msg.getId();
        String name = msg.getName();
        System.out.println("收到信息"+id+"，"+name);
    }




    //当遇到异常时
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭
        ctx.close();
        cause.printStackTrace();
    }
}
