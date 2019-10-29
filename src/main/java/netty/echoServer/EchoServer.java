package netty.echoServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author ken
 * @date 2019/3/8  16:16
 * @description
 */
public class EchoServer {

    private final int port;


    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
     /*   if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " <port>");
        }*/
        int port = 9090;
        new EchoServer(port).start();
    }

    public void start() throws InterruptedException {
        final EchoServerHandler handler = new EchoServerHandler();
        EventLoopGroup groups = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(groups)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(handler);

                        }
                    });
            ChannelFuture sync = b.bind().sync();

            sync.channel().closeFuture().sync();
        } finally {
            groups.shutdownGracefully().sync();

        }
    }
}
