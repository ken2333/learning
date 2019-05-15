package reflect;

/**
 * @author ken
 * @date 5/16/2019  12:16 AM
 * @description
 */
public class Person {

    private String name;
    private String sex;
    private  int age;

    public Person() {
        System.out.println("默认构造方法");
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say()
    {
        System.out.println("say()");
        return "返回" +
                "say";
    }
}
