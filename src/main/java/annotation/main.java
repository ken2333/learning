package annotation;

import java.lang.reflect.Method;

/**
 * @author ken
 * @date 2019-4-3  1:21
 * @description
 */
public class main {


    @UserCase(name = "赵日天",age=12,SEX = UserCase.sex.WOMAN)
    public void test ()
    {
        System.out.println("runing");
    }

    public static void main(String[] args) {
        Method[] methods = main.class.getMethods();

        for (Method method : methods) {
            UserCase annotation = method.getAnnotation(UserCase.class);
            if (annotation!=null)
            {
                System.out.println(annotation.name());
                System.out.println(annotation.SEX());
                System.out.println(annotation.age());
            }

        }
    }
}
