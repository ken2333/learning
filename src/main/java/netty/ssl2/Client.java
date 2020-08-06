package netty.ssl2;

import com.google.common.base.Charsets;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;
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
                            ChannelPipeline pipeline = ch.pipeline();
                            String cChatPath = "C:\\Users\\ken\\Desktop\\tem\\cChat.jks";
                            SSLEngine engine = SecureChatSslContextFactory.getClientContext(cChatPath, cChatPath)
                                    .createSSLEngine();//创建SSLEngine
                            engine.setUseClientMode(true);//客户方模式
                            pipeline.addLast("ssl", new SslHandler(engine));
                            //添加自定义的解码器
                            pipeline.addLast(new StringDecoder(Charsets.UTF_8));
                            pipeline.addLast(new StringEncoder(Charsets.UTF_8));
                            pipeline.addLast(new ClientHandle());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8080)).sync();
            channelFuture.addListeners(future -> {
                if (future.isSuccess()) {
                    System.out.println("客户端连接成功！");
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

    public static void main(String[] args) {
        Client.start();
    }
}
