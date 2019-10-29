package service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import java.util.Base64;
import java.util.List;

/**
 * @author ken
 * @date 2018-11-26  16:48
 * @description
 */
public class Client {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.setAddress("http://localhost:8082/hello");
        factoryBean.setServiceClass(Hello.class);
        Hello hello= (Hello)factoryBean.create();
        String hello1 = hello.hello();
        System.out.println("获取数据"+hello1);
        List<String> list = hello.getList();

        for(String a:list)
        {
            System.out.println(a);
        }
    }
    @Test
    public void test()
    {

        String test="数据库连接";
        byte[] encode = Base64.getEncoder().encode(test.getBytes());
        System.out.println(new String(encode));
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode));
    }
    @Test
    public void test2()
    {
        Hello hello=new HelloImpl();

    }
}
