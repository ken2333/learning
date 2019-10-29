package pro;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * @author ken
 * @date 2018-11-24  21:27
 * @description
 */
public class th1 {
    @Test
    public void test() throws InvalidProtocolBufferException {
        //构建内部类head,通过内部类的builder来构建数据
        pro.Test.Head.Builder  head=pro.Test.Head.newBuilder();
        //设置数据
        head.setHead01("撒大声地");
        head.setHead02(123);
        head.setHead03("head02");
        //获取响应的类
        pro.Test.Head build = head.build();
        //转换成字节数组,序列化完成
        byte[] bytes = build.toByteArray();
        System.out.println(Arrays.toString(bytes));

        //反序列化
        pro.Test.Head head1 = pro.Test.Head.parseFrom(bytes);
        System.out.println(head1.getHead01());
        System.out.println(head1.getHead02());
        System.out.println(head1.getHead03());
    }

    @Test
    public void test2()
    {
        InputStream in=new ByteArrayInputStream(new byte[123456]);
        ByteArrayOutputStream outputStream=null;
        outputStream.toByteArray();

    }
}
