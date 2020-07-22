package netty.groupChat.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class ServerChannelHandler extends ChannelInboundHandlerAdapter {

    private HashMap<String, ChannelHandlerContext> userMap;

    public ServerChannelHandler(HashMap<String, ChannelHandlerContext> userMap) {
        this.userMap = userMap;
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
                String name = read.getString("name");
                userMap.put(name, ctx);
                System.out.println(name + ":登录成功！");
                break;
            }
            case 10: {
                String name = read.getString("name");
                //执行群发的任务
                eventLoop.execute(() -> {
                    Iterator<String> iterator = userMap.keySet().iterator();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        ChannelHandlerContext channelHandlerContext = userMap.get(next);
                        if (!StringUtils.equals(next, name)) {
                            ByteBuf returnMsg = Unpooled.copiedBuffer(s, Charsets.UTF_8);
                            channelHandlerContext.writeAndFlush(returnMsg);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭
        ctx.close();
        //打印异常信息
        cause.printStackTrace();

    }
}
