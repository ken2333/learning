package status;

/**
 * @author ken
 * @date 2019/5/16  23:55
 * @description
 */
public class test {

    public static void main(String[] args) {
        Context context=new Context(new StatusA());
        context.request();
        context.request();
        context.request();
    }
}
