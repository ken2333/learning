package netty.groupChat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.HashMap;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class NettyServer {

    private int port;

    private HashMap<String, ChannelHandlerContext> userMap;

    public NettyServer(int port) {
        this.port = port;
        this.userMap = new HashMap<>();
    }

    public int getPort() {
        return port;
    }

    public HashMap<String, ChannelHandlerContext> getUserMap() {
        return userMap;
    }

    public void start() throws InterruptedException {

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup woker = new NioEventLoopGroup();

        ChannelFuture sync;
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, woker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new NettyServerChildHanler(userMap));

            sync = serverBootstrap.bind(port).sync();
            sync.addListeners((future -> {
                if (future.isSuccess()) {
                    System.out.println("服务器启动成功!");
                }
            }));
            sync.channel().closeFuture().sync();

        } finally {
            boss.shutdownGracefully();
            woker.shutdownGracefully();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        NettyServer nettyServer = new NettyServer(8080);
        nettyServer.start();
    }


}
