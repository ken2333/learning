package nio.cheat;

import com.alibaba.fastjson.JSONObject;
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

import static nio.cheat.Client.loginCode;
import static nio.cheat.Client.publicCode;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/10
 */
public class Server implements Runnable {
    Selector selector = null;
    @Override
    public void run() {
        try {
            Charset utf8 = Charset.forName("UTF-8");
              selector = Selector.open();
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
                    try {
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
                            int read = selectableChannel.read(attachment);
                            String str = new String(attachment.array(), 0, read);
                            attachment.clear();
                            JSONObject object = JSONObject.parseObject(str);
                            Integer code = object.getInteger("code");
                            switch (code)
                            {
                               case publicCode :{
                                   sendToEveryBody(str, next);
                               }
                                case  loginCode:{
                                    System.out.println(object.getString("name")+"登录成功！");
                                }
                            }
    /*                        selectableChannel.write(attachment);
                            next.interestOps(SelectionKey.OP_WRITE |SelectionKey.OP_READ);*/
                        }
                        if (next.isWritable()) {
                             SocketChannel channel = (SocketChannel) next.channel();
                             ByteBuffer byteBuffer = (ByteBuffer) next.attachment();
                             channel.write(byteBuffer);
                             byteBuffer.clear();
                             //取消通道的写事件
                             next.interestOps(next.interestOps() & (~SelectionKey.OP_WRITE));
                         }
                    } catch (IOException e) {
                        e.printStackTrace();
                        next.cancel();
                        next.channel().close();
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void sendToEveryBody(String str,SelectionKey key) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey selectionKey : keys) {
            if (selectionKey==key) {
                continue;
            }
        //    JSONObject object = JSONObject.parseObject(str);
           // object.
            SelectableChannel channel = selectionKey.channel();
            if(channel instanceof SocketChannel)
            {
                SocketChannel socketChannel = (SocketChannel) channel;
                socketChannel.write(ByteBuffer.wrap(str.getBytes()));
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Server());
        thread.start();
    }
}
