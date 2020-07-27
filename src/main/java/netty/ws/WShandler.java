package netty.ws;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/27
 */
public class WShandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String text = msg.text();
        System.out.println("服务器收到信息:"+text);
        ctx.writeAndFlush(new TextWebSocketFrame("服务器收到信息:" + text));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String s = ctx.channel().id().asLongText();
        System.out.println(s+"：建立连接！");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String s = ctx.channel().id().asLongText();
        System.out.println(s+"：断开连接！");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
        cause.printStackTrace();
    }
}
