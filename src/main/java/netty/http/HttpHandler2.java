package netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.*;
import org.apache.commons.codec.Charsets;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/18
 */
//httpObject   是客户端和服务器端通信的数据被封装成了Httpobject
public class HttpHandler2 extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            //创建response
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello，我是服务器", Charsets.UTF_8);
            DefaultFullHttpResponse defaultHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            HttpHeaders headers = defaultHttpResponse.headers();
            //设置响应的header
            headers.set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=utf-8");
            //设置长度
            headers.set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

            //返回response
            ctx.writeAndFlush(defaultHttpResponse);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
