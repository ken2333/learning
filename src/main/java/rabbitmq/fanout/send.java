package rabbitmq.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  23:11
 * @description
 */
public class send {
    private  static  String exchang_name="messages";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        //绑定指定的exchang名字，类型为fanout
        channel.exchangeDeclare(exchang_name,BuiltinExchangeType.FANOUT);
        channel.basicPublish(exchang_name,"",null,"发布订阅消息".getBytes());
        channel.close();
        connection.close();
    }
}
