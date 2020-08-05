package netty.customizeProto;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class Client {

    public static void start() {

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(group)
                    .channel(NioSocketChannel.class) //设置通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //添加自定义的解码器
                            ch.pipeline().addLast(new MyProtocolDecode() );
                            ch.pipeline().addLast(new MyProtocolEncoder() );
                            ch.pipeline().addLast(new ClientHandle());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8080)).sync();
            channelFuture.addListeners(future -> {
                if (future.isSuccess())
                {
                    System.out.println("客户端连接成功！");
                }else {
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

    public static void main(String[] args) {
        Client.start();
    }
}
