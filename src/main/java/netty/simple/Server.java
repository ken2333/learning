package netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author ken
 * @date 2020/7/12  23:12
 * @description
 */
public class Server {

    public void start() {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();  //创建一个boosGroup用于处理连接的事件
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();//创建一个workerGroup用于处理read 和write事件
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workerGroup)//设置bossGroup和workerGroup
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128) //设置accept队列的大小
                .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持长连接
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(null);
                    }
                });
        try {
            //监听8080端口，并启动
            ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            ChannelFuture closeFuture = channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

}
