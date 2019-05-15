package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ken
 * @date 5/16/2019  12:17 AM
 * @description
 */
public class test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {

        //获取class的方法
        Class c1=Person.class;
        Class c2=Class.forName("reflect.Person");

        System.out.println(c1.getName());

        //获取类的所有声明的成员
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        //生成实例,调用默认方法构造
        Object o = c1.newInstance();
        //获取指定的构造方法
        Constructor constructor = c1.getConstructor(String.class, String.class);
        //生成实例
        Person o2 = (Person) constructor.newInstance("sixoa", "男");
        System.out.println(o2.getName());

        if(o instanceof  Person)
        {
            System.out.println("是person");
        }
        //获取公共的方法
        Method[] methods = c1.getMethods();
        System.out.println("--------");
        for (Method method : methods) {
            if(method.getName().equals("say"))
            {
                //调用指定的方法，同时需要传入对象
                Object invoke = method.invoke(o);
                System.out.println(invoke instanceof String);
                System.out.println(invoke);
            }
        }
        
    }
}
