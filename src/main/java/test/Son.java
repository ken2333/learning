package test;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/01
 */
public class Son  extends  Father{

    public Son() {
        super();
    }

    public void test()
    {
        super.dosometing();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.dosometing();
        StringBuilder builder = new StringBuilder();
        builder.append("111111111111");
        System.out.println(builder.toString());
    }
}
