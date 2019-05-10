package decorator;

/**
 * @author ken
 * @date 2019/5/10  23:35
 * @description 装饰器抽象类，关键在域接口的保护成员，person
 *
 */
public abstract class Decorator  implements Person {

    protected Person person;


    public void setPerson(Person person) {
        this.person = person;
    }
}
