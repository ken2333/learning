package common.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/10
 */
public class SerializationUtilsTest {

    private  static String outPath;
    @Before
    public void before()
    {
        outPath="E:\\tem\\data";
    }

    @Test
    public void test() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(outPath+"/1.data");
        HashMap<String,String> map=new HashMap<>();
        map.put("name","你好");
        SerializationUtils.serialize(map,fileOutputStream);
        if (fileOutputStream!=null)
            fileOutputStream.close();
    }

    @Test
    public void test2() throws FileNotFoundException {
        FileInputStream inputStream=new FileInputStream(outPath+"/1.data");
        HashMap<String,String> deserialize = SerializationUtils.deserialize(inputStream);
        System.out.println(deserialize.size());
    }

    @Test
    public void test3()
    {
         int random = RandomUtils.nextInt();
        System.out.println(random);

        random=RandomUtils.nextInt(1,100);
        System.out.println(random);
    }


}
