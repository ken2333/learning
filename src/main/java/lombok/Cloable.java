package lombok;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * @author ken
 * @date 2018-11-25  21:37
 * @description
 */
public class Cloable {

    public static void main(String[] args) throws IOException {

        @Cleanup(value = "stop")
        CloseableTest test=new CloseableTest();
        @Cleanup
        InputStream in=new FileInputStream("D:\\ideaSpace\\Learning\\src\\main\\java\\lombok\\Cloable.java");
        @Cleanup
        OutputStream out=new FileOutputStream("d:\\tem\\tem.java");
        int i=0;
        byte [] bytes =new byte[1024];
        while((i=in.read(bytes))!=-1)
        {
            out.write(bytes,0,i);
        }

    }

    public static class    CloseableTest
    {

        public void  stop()
        {
            System.out.println("stop方法被执行了");
        }

        public void  close()
        {

            System.out.println("close方法被执行了");
        }

    }
}
