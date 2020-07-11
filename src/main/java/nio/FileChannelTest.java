package nio;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * describe: 使用FileChannel进行文件的复制
 * @author syh
 * @date 2020/07/05
 */
public class FileChannelTest {

    @Test
    public void test() throws IOException {
        File file = new File("E:\\tem\\tem.pdf");
        File file2 = new File("E:\\tem\\tem3.pdf");
        RandomAccessFile file1 = null;
        RandomAccessFile accessFile2 = null;
        try {
            file1 = new RandomAccessFile(file, "r");
            accessFile2 = new RandomAccessFile(file2, "rw");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel channel = file1.getChannel();
        FileChannel channel2 = accessFile2.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.clear();
        }

        if (channel != null) {
            channel.close();
        }
        if (channel2 != null) {
            channel2.close();
        }
    }

    @Test
    public void test2()
    {
        ByteBuffer allocate = ByteBuffer.allocate(512);
        allocate.putChar('是');
        allocate.putChar('是');
        allocate.putInt(1);
        allocate.putInt(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(allocate.position());
        System.out.println(allocate.getInt(2));


    }

    @Test
    public void mapped() throws Exception {
        RandomAccessFile fileInputStream = new RandomAccessFile("E:\\ideaSpace\\learning_ken2333\\learning\\src\\main\\java\\nio\\Nio.java","rw");

        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        map.put(0, (byte)'你');
        channel.close();
        fileInputStream.close();


    }
}
