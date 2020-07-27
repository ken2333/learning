package netty.groupChat.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.string.StringDecoder;

import java.util.HashMap;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class NettyServerChildHanler2 extends ChannelInitializer {
    private HashMap<String, ChannelHandlerContext> userMap;

    public NettyServerChildHanler2(HashMap<String, ChannelHandlerContext> userMap) {
        this.userMap = userMap;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("stringDecoder",new StringDecoder());
        ch.pipeline().addLast(new ServerChannelHandler3());
    }
}
