package netty.ssl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.customizeProto.MyProtocol;
import org.apache.commons.codec.Charsets;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ClientHandle extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("客户端收到消息：" + msg);
    }

    //在通道可以就绪时出发这方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().eventLoop().scheduleAtFixedRate(() -> {
            ctx.writeAndFlush("hello,server！" + new Date().toString());
        }, 2, 3, TimeUnit.SECONDS);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
