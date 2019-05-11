package proxy.StaticProxy;

/**
 * @author ken
 * @date 2019/5/11  22:51
 * @description 代理类
 */
public class Proxy  implements StaticProxy{

    StaticProxy staticProxy;

    public Proxy(StaticProxy staticProxy) {
        this.staticProxy = staticProxy;
    }

    @Override
    public void dosomething() {
        staticProxy.dosomething();
    }
}
