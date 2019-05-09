package proxy;

/**
 * @author ken
 * @date 2019/5/8  23:25
 * @description
 */
public class ProxyObject implements   Subject {

    private RealSubject realSubject;

    public ProxyObject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }
    @Override
    public void dosomething() {
            realSubject.dosomething();
    }

    public static void main(String[] args) {

    }
}
