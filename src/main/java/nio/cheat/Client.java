package nio.cheat;

import com.alibaba.fastjson.JSONObject;
import nio.NioTest.Buffers;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/10
 */
public class Client extends Thread {

    //对每个人
    public static final int publicCode = 1;

    //登录代码
    public static final int loginCode = 2;


    private SocketAddress address;

    private Selector selector;

    private String name;

    SelectionKey register;

    public Client(SocketAddress address,String name) {
        this.address = address;
        this.name = name;
    }


    @Override
    public void run() {
        try {

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            /*向服务器发起连接,一个通道代表一条tcp链接*/
            socketChannel.connect(address);
            selector = Selector.open();
            //注册
            register = socketChannel.register(selector, SelectionKey.OP_READ , new Buffers(512, 512));



            /*等待三次握手完成*/
            while (!socketChannel.finishConnect()) {

            }
            write("登录成功！", loginCode);


            while (true) {
           /*     Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                socketChannel.write(ByteBuffer.wrap(s.getBytes()));*/
                int select = selector.select();
                if (select == 0)
                    continue;
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isReadable()) {
                        Buffers byteBuffer = (Buffers) next.attachment();
                        ByteBuffer readBuffer = byteBuffer.getReadBuffer();
                        SocketChannel channel = (SocketChannel) next.channel();
                        int read = channel.read(readBuffer);
                        String str = new String(readBuffer.array(), 0, read, "utf-8");
                        JSONObject object = JSONObject.parseObject(str);
                        System.out.println(object.getString("name")+":"+object.getString("msg"));
                        readBuffer.clear();
                    }
                   if (next.isWritable()) {
                        Buffers byteBuffer = (Buffers) next.attachment();
                        ByteBuffer writeBuffer = byteBuffer.getWriteBuffer();
                        SocketChannel channel = (SocketChannel) next.channel();
                        channel.write(writeBuffer);
                        writeBuffer.clear();
                        next.interestOps(next.interestOps() & ~SelectionKey.OP_WRITE);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void write(String str,Integer code) throws IOException {
        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("msg", str);
        object.put("code", code);
        SocketChannel channel = (SocketChannel) register.channel();
        channel.write(ByteBuffer.wrap(object.toJSONString().getBytes("utf-8")));

    }



    public static void main(String[] args) throws Exception {
        Client client = new Client(new InetSocketAddress(8080),"ken");

        client.start();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String next = sc.next();
            if (StringUtils.isNotBlank(next))
                client.write(next,publicCode);
        }

    }
}
