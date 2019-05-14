package builder;

/**
 * @author ken
 * @date 2019/5/14  20:20
 * @description
 */
public class FatPersonBuilder extends PersonBuilder {
    @Override
    protected void head() {
        System.out.println("建造大头");
    }

    @Override
    protected void hand() {
        System.out.println("建造大手");
    }

    @Override
    protected void leg() {
        System.out.println("建造腿");
    }

    @Override
    protected void body() {
        System.out.println("建造身体");
    }
}
