package AIO;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/10  12:01
 * @description
 */
public class channelHandle implements CompletionHandler<AsynchronousSocketChannel,Object> {
    final ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

    private AsynchronousServerSocketChannel server;

    public channelHandle(AsynchronousServerSocketChannel server) {
        this.server = server;
    }

    @Override
    public void completed(AsynchronousSocketChannel result, Object attachment) {
        Future<Integer> future=null;
        try {
            byteBuffer.clear();
            result.write(byteBuffer).get(100,TimeUnit.SECONDS);
            byteBuffer.flip();
            future=result.write(byteBuffer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        finally {
            server.accept(null,this);
            try {
                future.get();
                result.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void failed(Throwable exc, Object attachment) {

    }
}
