package  decorator;

/**
 * @author ken
 * @date 2019/5/10  23:38
 * @description
 */
public class Component implements Person {

    private  String name;

   Person person;

    public Component(String name) {
       this.name=name;
    }

    @Override
    public void show() {
        System.out.println(name+"开始操作!");
    }
    /*
    * 执行的顺序首先b.执行的时候会执行person.show()，在b的person是a,
    * a的person是Component的对象person,所以是person.show()->a.show()
    * ->b.show()。装饰器可以随时的通过继承Decortor这个抽象类来进行扩张
    * ，而且在装饰器中还可以调整装饰器运行的顺序
    * */
    public static void main(String[] args) {
        Person person=new Component("zhao");

       DecoratorA a=new DecoratorA();
       DecoratorB b=new DecoratorB();

        a.setPerson(person);
        b.setPerson(a);
        b.show();
    }
}
