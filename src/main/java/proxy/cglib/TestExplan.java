package proxy.cglib;

import org.junit.Test;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/26
 */
public class TestExplan {
    @Test
   public void test()
    {
        ProxyObjext objext = new ProxyObjext();
        ProxyFactory proxyFactory = new ProxyFactory(objext);
        ProxyObjext proxyInstance = (ProxyObjext) proxyFactory.getProxyInstance();
        proxyInstance.save();

    }

    public static void main(String[] args) {
        ProxyObjext objext = new ProxyObjext();
        ProxyFactory proxyFactory = new ProxyFactory(objext);
        ProxyObjext proxyInstance = (ProxyObjext) proxyFactory.getProxyInstance();
        proxyInstance.save();
    }
}
