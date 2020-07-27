package netty.ws;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * describe: websocks服务器
 *
 * @author syh
 * @date 2020/07/27
 */
public class WSServer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private void init() {
        logger.info("正在启动websocket服务器");
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, work);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("logging", new LoggingHandler("DEBUG"));//设置log监听器，并且日志级别为debug，方便观察运行流程
                    pipeline.addLast("http-codec", new HttpServerCodec());//设置解码器
                    pipeline.addLast("aggregator", new HttpObjectAggregator(8192));//聚合器，使用websocket会用到
                    pipeline.addLast("wsHandler", new WebSocketServerProtocolHandler("/test"));
                    pipeline.addLast("handler", new WShandler());//自定义的业务handler
                }
            });

            ChannelFuture sync = bootstrap.bind(8080).sync();
            sync.addListeners(future -> {
                if (future.isSuccess()) {
                    logger.info("启动成功！");
                }
            });
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.info("运行出错：" + e);
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
            logger.info("websocket服务器已关闭");
        }
    }

    public static void main(String[] args) {
        WSServer server = new WSServer();
        server.init();

    }
}
