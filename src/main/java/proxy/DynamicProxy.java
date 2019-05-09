package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ken
 * @date 2019/5/8  23:28
 * @description
 */
public class DynamicProxy implements InvocationHandler {
    private  Object object;


    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(object, args);
        return invoke;
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject("泰日天");
        DynamicProxy proxy=new DynamicProxy(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Subject subject=(Subject)Proxy.newProxyInstance(classLoader,new Class[]{Subject.class},proxy);
        subject.dosomething();
    }
}
