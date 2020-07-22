package netty.groupChat.client;

import com.alibaba.fastjson.JSONObject;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.commons.codec.Charsets;

import java.net.InetSocketAddress;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class NettyClient extends Thread {

    private int port;


    private ChannelHandlerContext ch;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public ChannelHandlerContext getCh() {
        return ch;
    }

    public void setCh(ChannelHandlerContext ch) {
        this.ch = ch;
    }


    NettyClient(String name, int port) {
        super(name);
        this.port = port;
    }

    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            NettyClient self = this;
            bootstrap.group(group)
                    .channel(NioSocketChannel.class) //设置通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHandle(self));
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1", port)).sync();
            channelFuture.addListeners(future -> {
                if (future.isSuccess()) {
                    System.out.println("客户端连接成功");
                } else {
                    System.out.println("客户端连接失败！");
                }
            });
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }


    }

    public void write(String content) {
        ch.channel().eventLoop().execute(() -> {
            JSONObject object = new JSONObject();
            object.put("code", 10);
            object.put("name", getName());
            object.put("msg", content);
            object.put("time", System.currentTimeMillis());
            ByteBuf byteBuf = Unpooled.copiedBuffer(object.toString(), Charsets.UTF_8);
            ch.writeAndFlush(byteBuf);
        });
    }


}
