package conneciont;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ken
 * @date 2019/1/25  16:32
 * @description
 */
public class th5 {

    @Test
    public void test()
    {
        HashMap<String,Student> map=new HashMap<>();

        map.put("one",new Student("one",1));

        map.put("two",new Student("two",2));

        Set<Map.Entry<String, Student>> entries = map.entrySet();
       for(Map.Entry<String, Student> tem:entries)
       {
           System.out.println(tem.getKey());
           System.out.println(tem.getValue().getName());
       }


    }

    public static  class Student
    {
        private String name;

        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
