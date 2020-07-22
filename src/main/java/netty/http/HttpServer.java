package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.net.InetSocketAddress;

/**
 * @author ken
 * @date 2019/3/5  23:14
 * @description 一个nio做的http服务器
 */
public class HttpServer {
    public void start() throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup wokerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup, wokerGroup)
                    //channel实现的类型
                    .channel(NioServerSocketChannel.class)
                    //设置处理器
                    .childHandler(new HttpChannelInitializer())
                    //determining the number of connections queued
                    //指定连接队列的数量
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //保持长连接
                     .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

            //监听8080端口，之后等待执行完成
            ChannelFuture sync = serverBootstrap.bind(new InetSocketAddress(8080)).sync();
            sync.addListeners(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("启动服务器成功！");
                    }

                }
            });
            //等待异步执行完成
            sync.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpServer().start();
    }

}
