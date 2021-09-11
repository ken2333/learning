package protostuff;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.ProtostuffOutput;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ken
 * @date 2019/7/6  0:25
 * @description
 */
public class test {

    public static void main(String[] args) {
        List<Products> pList=new ArrayList<>();
        for(int i=0;i<10000;i++)
        {
            pList.add(new Products("name"+i, 100+1, new Date()));
        }
        //开始序列号
        long start = System.currentTimeMillis();
        List<byte[]> bytes = new ArrayList<byte[]>();
        Schema<Products> schema = RuntimeSchema.getSchema(Products.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(4096);
        byte[] protostuff = null;
        for(Products p : pList) {
            try {
                protostuff = ProtostuffIOUtil.toByteArray(p, schema, buffer);
                bytes.add(protostuff);
            } finally {
                buffer.clear();
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("结束时间"+(end-start));

        //反序列化
          start = System.currentTimeMillis() ;
          List<Products> list = new ArrayList<Products>();
        for(byte[] bs : bytes) {
            Products product = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bs, product, schema);
            list.add(product);
            System.out.println(product);
        }
          end = System.currentTimeMillis() ;
        System.out.println("消耗的时间"+(end-start));
    }
    @Test
    public void test()
    {


    }
}
