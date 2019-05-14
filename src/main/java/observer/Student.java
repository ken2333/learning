package observer;

/**
 * @author ken
 * @date 2019/5/14  20:52
 * @description
 */
public class Student implements    Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name+"update");
    }
}
