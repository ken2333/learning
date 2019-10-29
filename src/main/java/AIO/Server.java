package AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * @author ken
 * @date 2019/3/10  11:52
 * @description
 */
public class Server {

    private static  int port=8080;

    private AsynchronousServerSocketChannel server;


    public Server( ) throws IOException {
        this.server =AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
    }

    public void start()
    {

        System.out.println("line on"+port);

        server.accept(null,new channelHandle(server));
    }
}

