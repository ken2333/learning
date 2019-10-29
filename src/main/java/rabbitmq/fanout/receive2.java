package rabbitmq.fanout;

import com.rabbitmq.client.*;
import rabbitmq.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  23:17
 * @description
 */
public class receive2 {

    private  static  String exchang_name="messages";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchang_name,BuiltinExchangeType.FANOUT);
        String queueName = channel.queueDeclare().getQueue();


        channel.queueBind(queueName,exchang_name,"");

        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接受者2:"+new String(body,"utf-8"));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,false,consumer);
    }
}
