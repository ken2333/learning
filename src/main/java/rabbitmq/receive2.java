package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  15:17
 * @description
 */
public class receive2 {
    private  static  String name="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);//只发送一个消息过去，只有消息确认了，才会发送下一个
        channel.queueDeclare(name, false, false, false, null);
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消息2"+new String(body,"utf-8"));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //确认签收消息，第二个参数false表示确认签收，true表示拒绝签收
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(name,false,consumer);
    }
}
