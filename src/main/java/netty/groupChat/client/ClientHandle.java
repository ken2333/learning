package netty.groupChat.client;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.codec.Charsets;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class ClientHandle extends ChannelInboundHandlerAdapter {
    private NettyClient nettyClient;

    public ClientHandle(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        nettyClient.setCh(ctx);
        JSONObject object = new JSONObject();
        object.put("code", 1);
        object.put("name", nettyClient.getName());
        object.put("msg", "登录协议！");
        ctx.writeAndFlush(Unpooled.copiedBuffer(object.toJSONString(),Charsets.UTF_8));
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        String s = byteBuf.toString(Charsets.UTF_8);
        JSONObject read = JSONObject.parseObject(s);

        Integer code = read.getInteger("code");
        switch (code) {
            case 10:{
                String name = read.getString("name");
                String message = read.getString("msg");
                System.out.println(name+"："+message);
                break;
            }
        }
    }
}
