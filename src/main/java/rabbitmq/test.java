package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  13:21
 * @description  helloworld项目
 */
public class test {

    private final  static  String QUEUE_NAME="hello";
    public static Connection getConnection () throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.186.10");//设置
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123");
        factory.setVirtualHost("root");
        return  factory.newConnection();
    }
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection =getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        //参数一：队列名称
        //参数二：是否持久化，false则不会持久化，在重启后会消失
        //参数三：是否私有化，若果私有化了，其他的通道不可以访问当前的队列
        //参数四：是否能够自动删除
        //参数五：其他参数
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!你好";
        //发送内容
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("utf-8"));
        //关闭链接
        connection.close();
        System.out.println(" [x] Sent '" + message + "'");
    }

    @Test
    public void test() throws IOException, TimeoutException, InterruptedException {
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        QueueingConsumer consumer=new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME,true,consumer);
       while (true)
       {
           QueueingConsumer.Delivery delivery = consumer.nextDelivery();
           System.out.println(new String(delivery.getBody(),"utf-8"));
       }

    }
}
