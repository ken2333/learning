package proxy.StaticProxy;

import proxy.RealSubject;

/**
 * @author ken
 * @date 2019/5/11  22:51
 * @description
 */
public class test {
    public static void main(String[] args) {

        StaticProxy staticProxy=new RealObject();

        Proxy proxy=new Proxy(staticProxy);

        proxy.dosomething();
    }
}
