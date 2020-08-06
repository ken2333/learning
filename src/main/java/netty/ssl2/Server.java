package netty.ssl2;

import com.google.common.base.Charsets;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @author ken
 * @date 2020/7/12  23:12
 * @description
 */
public class Server {

    public static void start() {

        //创建一个boosGroup用于处理连接的事件，其中nThreads表示线程数
        //默认情况下 nThreads *2 就是NioEventLoop的数量
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();//创建一个workerGroup用于处理read 和write事件
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workerGroup)//设置bossGroup和workerGroup
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128) //设置accept队列的大小
                .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持长连接
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        String sChatPath = "C:\\Users\\ken\\Desktop\\tem\\sChat.jks";
                        SSLEngine engine = SecureChatSslContextFactory.getServerContext(sChatPath,sChatPath).createSSLEngine();
                        engine.setUseClientMode(false);//设置为服务器模式
                        engine.setNeedClientAuth(true);//不需要客户端认证，默认为false，故不需要写这行。
                        pipeline.addLast("ssl", new SslHandler(engine));
                        //添加自定义的解码器
                        ch.pipeline().addLast(new StringDecoder(Charsets.UTF_8));
                        ch.pipeline().addLast(new StringEncoder(Charsets.UTF_8));
                        ch.pipeline().addLast(new ServerHandle());
                    }
                });
        try {
            //监听8080端口，并启动
            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            channelFuture.addListeners(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("服务器启动成功");
                    } else {
                        System.out.println("服务器启动失败");
                    }

                }
            });
            ChannelFuture closeFuture = channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        Server.start();
    }

}
