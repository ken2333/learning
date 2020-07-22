package netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/17
 */
public class HttpChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //加入处理器
        //HttpServerCodec是 netty提供的 http的编解码器
        ch.pipeline().addLast("HttpServerCodec",new HttpServerCodec());
        //设置相应
        ch.pipeline().addLast("HttpHandler2",new HttpHandler2());
    }


}
