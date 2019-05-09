package proxy;

/**
 * @author ken
 * @date 2019/5/8  23:25
 * @description
 */
public class RealSubject implements   Subject {

    private String name;

    public RealSubject() {
    }

    public RealSubject(String name) {
        this.name = name;
    }

    @Override
    public void dosomething() {
        System.out.println(name+"执行了方法");
    }
}
