package netty.customizeProto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.apache.commons.codec.Charsets;

import java.net.SocketAddress;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ServerHandle extends SimpleChannelInboundHandler<MyProtocol> {

    private int count = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtocol msg) throws Exception {
        byte[] data = msg.getData();
        String tem = new String(data, Charsets.UTF_8);
        System.out.println("服务器收到消息："+count+","+tem);
        count++;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    //当遇到异常时
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭
        ctx.close();
        cause.printStackTrace();
    }
}
