package service;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author ken
 * @date 2018-11-26  16:09
 * @description
 */
public class Main {

    public static void main(String[] args) {
        JaxWsServerFactoryBean  factoryBean=new JaxWsServerFactoryBean();
        factoryBean.setServiceClass(HelloImpl.class);
        factoryBean.setAddress("http://localhost:8082/hello");
        Server  server=factoryBean.create();
        server.start();

    }
}
