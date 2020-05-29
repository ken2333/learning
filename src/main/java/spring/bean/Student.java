package spring.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author ken
 * @date 2019/3/20  19:55
 * @description
 */
@Data
@ToString
public class Student {
    
    @Value("${name}")
    private String name;
    private String sex;
    private  Integer age;

    public Student() {
    }

    public Student(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge( Integer age) {
        this.age = age;
    }

    public void test(@NonNull String nonNull)
    {
        System.out.println(nonNull);
    }

    public  static  class  Infor
    {
        private  String infor;

        public String getInfor() {
            return infor;
        }

        public void setInfor(String infor) {
            this.infor = infor;
        }
    }
}
