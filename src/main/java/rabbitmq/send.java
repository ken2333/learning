package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  15:12
 * @description
 */
public class send {

    private  static  String name="hello";
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection=ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(name,false,false,false,null);
        for(int i=0;i<100;i++)
        {
            channel.basicPublish("",name,null,("消息"+i).getBytes());
        }
        connection.close();
    }
}
