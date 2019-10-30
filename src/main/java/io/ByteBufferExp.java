package io;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author ken
 * @date 2019/10/28  22:19
 * @description
 */
public class ByteBufferExp {

    @Test
    public void test()
    {
        CharBuffer charBuffer=CharBuffer.allocate(128);
        charBuffer.append("我爱你😍");
        //切换成读取模式
        charBuffer.flip();

        //创建解码器
        Charset charset=Charset.forName("utf-8");
        ByteBuffer encode = charset.encode(charBuffer);

        byte[] bytes = Arrays.copyOf(encode.array(), encode.limit());
        System.out.println(Arrays.toString(bytes));

        ByteBuffer bf=ByteBuffer.allocate(1024);
        bf.put(bytes);
        //由写模式换成读取模式
        bf.flip();
        CharBuffer decode = charset.decode(bf);
        char[] chars = Arrays.copyOf(decode.array(), decode.limit());
        System.out.println(new String(chars));
    }
}
