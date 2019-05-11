package proxy.StaticProxy;

/**
 * @author ken
 * @date 2019/5/11  22:50
 * @description 真正的执行的对象
 */
public class RealObject  implements  StaticProxy{
    @Override
    public void dosomething() {
        System.out.println("realObject执行方法");
    }
}
