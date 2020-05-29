package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    @Test
    public void test2()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Student bean = applicationContext.getBean(Student.class);
        bean.test(null);
    }

  @Test
  public void test3() {
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
      Student student=new Student();
      //注册外面的对象
      applicationContext.getBeanFactory().registerSingleton("student",student);
      //重新刷新列表
      applicationContext.refresh();
      //从容器中获取bean
      Student student1 = (Student) applicationContext.getBean("student");
      System.out.println(student==student1); //true

  }

  @Test
  public void test4() {
      ApplicationContext context = new ClassPathXmlApplicationContext("appliction.xml");
      Student student1 = context.getBean("student1", Student.class);
      Student student2 = context.getBean("student2", Student.class);
      Student student = context.getBean("student", Student.class);
      System.out.println(student1==student2);
      System.out.println(student==student1);

      Student.Infor infor= (Student.Infor) context.getBean("infor");
      System.out.println(infor.getInfor());
  }
}
