package Threand;

/**
 * @author ken
 * @date 2019/3/9  18:21
 * @description
 */
public class th10 {

    private final  String name;

    private  final  int age;


    public th10(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        th10 t=new th10("sun",12);
        System.out.println(t.getAge());
    }
}
