package nio.cheat;

import com.sun.star.view.SelectionType;
import org.bson.ByteBuf;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/10
 */
public class Server implements Runnable {
    @Override
    public void run() {
        try {
            Charset utf8 = Charset.forName("UTF-8");
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置是否阻塞
            serverSocketChannel.configureBlocking(false);
            //注册事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //监听端口
            serverSocketChannel.bind(new InetSocketAddress(8080));
            while (true) {
                int select = selector.select();
                if (select == 0)
                    continue;
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    //移除
                    it.remove();
                    //判断是否是连接事件
                    if (next.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        //设置成非阻塞
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        System.out.println("连接成功!");
                    }
                    if (next.isReadable()) {
                        ByteBuffer attachment = (ByteBuffer) next.attachment();
                        SocketChannel selectableChannel = (SocketChannel) next.channel();
                        selectableChannel.read(attachment);
                        attachment.flip();

                        selectableChannel.write(attachment);

                        next.interestOps(SelectionKey.OP_WRITE |SelectionKey.OP_READ);
                    }
                   if (next.isWritable()) {
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) next.attachment();
                        channel.write(byteBuffer);
                        byteBuffer.compact();
                        //取消通道的写事件
                        next.interestOps(next.interestOps() & (~SelectionKey.OP_WRITE));
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Server());
        thread.start();
    }
}
