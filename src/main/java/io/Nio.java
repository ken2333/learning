package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ken
 * @date 2019/10/28  21:28
 * @description 一个简单的读写操作
 */
public class Nio {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("E:\\IdeaProject\\learning\\src\\main\\java\\io\\Nio.java");
        FileOutputStream out=new FileOutputStream("C:\\Users\\ken\\Desktop\\tem\\tem.java");

        FileChannel channel = fileInputStream.getChannel();
        FileChannel outChannel = out.getChannel();
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        while(true){
            //判断是否读完文件
            int eof =channel.read(buffer);
            if(eof==-1){
                break;
            }
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        channel.close();
        outChannel.close();
        fileInputStream.close();
        out.close();
    }
}
