package combination;

/**
 * @author ken
 * @date 2019/5/19  0:14
 * @description
 */
public class Department  implements  Root{
    private  String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Root root) {
        System.out.println("不支持");
    }

    @Override
    public void remove(Root root) {
        System.out.println("不支持");

    }

    @Override
    public void show() {
        System.out.println(this.name);
    }

    @Override
    public void handle() {

    }
}
