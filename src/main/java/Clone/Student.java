package Clone;

import lombok.Data;
import org.junit.Test;

import java.util.Date;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/04
 */
@Data
public class Student implements  Cloneable {

    private  String name;

    private  int age;

    private Date date;


    public Student(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Student() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.setDate((Date) getDate().clone());
        return  clone;
    }



    @Test
    public void test() throws CloneNotSupportedException {
        }


    public static void main(String[] args) throws CloneNotSupportedException {
        Student s = new Student();
        s.setDate(new Date());
        Student s1 = (Student) s.clone();
        if (s.getDate()==s1.getDate()) {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

    }




}


