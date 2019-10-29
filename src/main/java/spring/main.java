package spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import spring.bean.MainConfig;
import spring.bean.MainConfig2;
import spring.bean.Student;

/**
 * @author ken
 * @date 2019/3/20  19:48
 * @description
 */

public class main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Student bean = applicationContext.getBean(Student.class);
        Student bean2 = applicationContext.getBean(Student.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Student.class);
        System.out.println(bean);
        for (String tem2 : beanNamesForType) {
            System.out.println(tem2);
        }
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String tem : beanDefinitionNames) {
            System.out.println(tem);
        }
        System.out.println(bean == bean2);
    }

    @Test
    public void test() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Student bean = applicationContext.getBean(Student.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        System.out.println(environment.getPropertySources());
        System.out.println(bean.getName());
    }

}
