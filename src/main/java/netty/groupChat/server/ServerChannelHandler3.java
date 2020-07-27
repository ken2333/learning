package netty.groupChat.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * describe: 这个使用stringdecoder
 *
 * @author syh
 * @date 2020/07/22
 */
public class ServerChannelHandler3 extends SimpleChannelInboundHandler<String> {


    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        JSONObject read = JSONObject.parseObject(msg);
        Integer code = read.getInteger("code");
        System.out.println("收到：" + msg);
        switch (code) {
            case 1: {

                break;
            }
            case 10: {

            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 第一次建立连接的时候，就触发这个方法
     *
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
     * 当ChannelHanler被移除上下文内容后，触发的事件，这时候不能处理事件.
     * 可以用在客户端离线的时候，做出相关的动作
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("下线提醒！");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
        //打印异常信息
        cause.printStackTrace();

    }
}
