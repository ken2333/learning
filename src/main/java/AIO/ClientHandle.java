package AIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author ken
 * @date 2019/3/10  12:19
 * @description
 */
public class ClientHandle implements CompletionHandler<Integer,Object> {

    private AsynchronousSocketChannel client;

    private  ByteBuffer buffer;

    public ClientHandle(AsynchronousSocketChannel client, ByteBuffer buffer) {
        this.client = client;
        this.buffer = buffer;
    }

    @Override
    public void completed(Integer result, Object attachment) {
        buffer.flip();
        System.out.println(new String(buffer.array()));
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, Object attachment) {

    }
}
