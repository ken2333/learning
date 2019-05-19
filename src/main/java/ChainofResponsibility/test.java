package ChainofResponsibility;



/**
 * @author ken
 * @date 2019/5/19  21:02
 * @description
 */
public class test {

    public static void main(String[] args) {

        //首先创建请求
        RequestTask requestTask=new RequestTask("[]");

        //然后创建处理人
        Handler handle=new Handler1("test1");
        Handler handle2=new Handler2("test2");
        //这里的handle2设置下一个处理人就是test1
        handle2.setNextHandle(handle);
        //开始处理请求
        handle2.handle(requestTask);
    }
}
