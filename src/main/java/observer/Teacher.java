package observer;

/**
 * @author ken
 * @date 2019/5/14  20:55
 * @description
 */
public class Teacher extends Informer {

    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        Student student=new Student("小赵");
        teacher.add(student);
        teacher.update();
    }
}
