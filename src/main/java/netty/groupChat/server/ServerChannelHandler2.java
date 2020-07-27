package netty.groupChat.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;

/**
 * describe: 这个是看视频后，改进的
 *
 * @author syh
 * @date 2020/07/22
 */
public class ServerChannelHandler2 extends ChannelInboundHandlerAdapter {


    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);




    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 第一次建立连接的时候，就触发这个方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);
        System.out.println("上线提醒！");
    }

    /**
     *  当ChannelHanler被移除上下文内容后，触发的事件，这时候不能处理事件.
     *  可以用在客户端离线的时候，做出相关的动作
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("下线提醒！");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        EventLoop eventLoop = ctx.channel().eventLoop();
        //把数据转化成string
        ByteBuf byteBuf = (ByteBuf) msg;
        String s = byteBuf.toString(CharsetUtil.UTF_8);
        JSONObject read = JSONObject.parseObject(s);
        Integer code = read.getInteger("code");
        System.out.println("收到：" + s);
        switch (code) {
            case 1: {

                break;
            }
            case 10: {

            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
        //打印异常信息
        cause.printStackTrace();

    }
}
