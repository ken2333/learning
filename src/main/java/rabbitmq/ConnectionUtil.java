package rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ken
 * @date 2019/3/4  15:12
 * @description
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.186.10");//设置
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123");
        factory.setVirtualHost("root");
        return  factory.newConnection();
    }
}
