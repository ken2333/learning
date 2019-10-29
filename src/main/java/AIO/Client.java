package AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * @author ken
 * @date 2019/3/10  12:17
 * @description
 */
public class Client {
    public static void main(String[] args) throws IOException {
        final AsynchronousSocketChannel socketChannel=AsynchronousSocketChannel.open();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
      //  socketChannel.connect(new InetSocketAddress("127.0.0.1",8080),);

    }
}
