package conneciont;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FactoryUtils;
import org.junit.Test;

/**
 * @author ken
 * @date 2018-12-1  23:18
 * @description  工厂工具的使用
 */
public class th4 {
    @Test
    public void test()
    {
        Person person=new Person("112","小米",14);
        Factory<Person> personFactory = FactoryUtils.constantFactory(person);
        Person person1 = personFactory.create();
        Person person2 = personFactory.create();
        Person person3 = personFactory.create();
        Person person4 = personFactory.create();
        System.out.println(person==person1);
        System.out.println(person1==person2);
        System.out.println(person2=person3);
        System.out.println(person3==person4);
        System.out.println(person4==person);
    }

    @Test
    public void test2()
    {
        Factory<Person> personFactory = FactoryUtils.instantiateFactory(Person.class);
        Person person = personFactory.create();
        Person person2 = personFactory.create();
        Person person3 = personFactory.create();
        System.out.println(person==person2);
        System.out.println(person3==person2);


    }

    @Test
    public void test3()
    {
        Person person=new Person("123","sun",12);
        Factory<Person> personFactory = FactoryUtils.prototypeFactory(person);
        Person person1 = personFactory.create();
        Person person2 = personFactory.create();
        System.out.println("=="+(person1==person2));
        System.out.println(person1);
        System.out.println(person2);

    }
    @Data
    @AllArgsConstructor
  public   static  class  Person
    {



        @Override
        public Object clone() throws CloneNotSupportedException {
            return new Person(this.id,this.name,this.age);
        }

        private String id;

        public Person() {
        }

        private String name;

        private  int age;
    }

}
