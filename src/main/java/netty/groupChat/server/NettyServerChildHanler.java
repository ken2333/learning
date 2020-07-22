package netty.groupChat.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;

import java.util.HashMap;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class NettyServerChildHanler extends ChannelInitializer {
    private HashMap<String, ChannelHandlerContext> userMap;

    public NettyServerChildHanler(HashMap<String, ChannelHandlerContext> userMap) {
        this.userMap = userMap;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new ServerChannelHandler(userMap));
    }
}
