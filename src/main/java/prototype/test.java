package prototype;

/**
 * @author ken
 * @date 2019/5/13  20:38
 * @description
 */
public class test {

    public static void main(String[] args) throws CloneNotSupportedException {

        PersonInfo  personInfo=new PersonInfo("a1",11,"男");
        System.out.println(personInfo);
        PersonInfo personInfo2= (PersonInfo) personInfo.clone();
        personInfo2.setAge(12);
        personInfo2.setName("a2");
        System.out.println(personInfo);
        System.out.println(personInfo2);

    }
}
