package rabbitmq.rout;

import com.rabbitmq.client.*;
import rabbitmq.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  23:17
 * @description
 */
public class receive3 {

    private static  String exchange_name="test";


    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queueName="route3";
        channel.queueDeclare(queueName,false,false,false,null);
        channel.queueBind(queueName,exchange_name,"key3");
        channel.queueBind(queueName,exchange_name,"key2");
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接受者1:"+new String(body,"utf-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,consumer);
    }
}
