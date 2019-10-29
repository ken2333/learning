package rabbitmq.rout;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/5  10:16
 * @description  路由模式发送者
 */
public class sent {

    private static  String exchange_name="test";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机的name和类型
         channel.exchangeDeclare(exchange_name, BuiltinExchangeType.DIRECT);
         //推送消息到指定的交换机，同时带上路由的关键字
         channel.basicPublish(exchange_name,"key3",null,"消息3".getBytes());
         channel.close();
         connection.close();

    }
}
