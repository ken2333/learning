package ChainofResponsibility;

/**
 * @author ken
 * @date 2019/5/19  20:46
 * @description 处理人 ,处理人有两个关键，就是handle这个方法，保证了处理请求的统一方法，
 * setNextHandle方法保证了客户端可以按照自定义的规则来设置请求链的执行顺序和人数.
 */
public  abstract class Handler {

    public  final  static Integer SUCESS=1;
    public  final  static Integer Faile=0;

    protected  String name;

    protected  Handler nextHandle;

    public abstract  int handle(Request request);

    public Handler getNextHandle() {
        return nextHandle;
    }

    public void setNextHandle(Handler nextHandle) {
        this.nextHandle = nextHandle;
    }

    public Handler(String name) {
        this.name=name;
    }

}
