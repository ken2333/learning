package pro;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;

import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static io.protostuff.runtime.RuntimeSchema.getSchema;

/**
 * @author ken
 * @date 2018-11-25  20:19
 * @description
 */
public class protostuff {

    //
    private static LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

    private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap<>();

    public static void main(String[] args) throws UnsupportedEncodingException {

        //序列化
        Student studnet=new Student(12345L,"赵日天",21);
        byte[] serialize = serialize(studnet);
        System.out.println(Arrays.toString(serialize));

        //反序列化
        Student studnet1 = deserialize(serialize,Student.class);
        System.out.println(studnet1.getAge());
        System.out.println(studnet1.getId());
        System.out.println(studnet1.getName());


    }

   /* @SuppressWarnings("unchecked")*/
    public static <T> byte[] serialize(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(clazz);
        byte[] data;
        try {
            data = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } finally {
            buffer.clear();
        }

        return data;
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) schemaCache.get(clazz);
        if (Objects.isNull(schema)) {
            //这个schema通过RuntimeSchema进行懒创建并缓存
            //所以可以一直调用RuntimeSchema.getSchema(),这个方法是线程安全的
            schema = RuntimeSchema.getSchema(clazz);
            if (Objects.nonNull(schema)) {
                schemaCache.put(clazz, schema);
            }
        }

        return schema;
    }

    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        Schema<T> schema = getSchema(clazz);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }



}
