package res15;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kem
 * @date 2019/7/1  16:57
 * @description
 */
public class ImplementClass extends AbstratClass {
    @Override
    public void abstractMethod() {

        System.out.println("实际方法");
    }

    private List<String> list;


    public ImplementClass(String name, List<String> list) {
        super(name);
        this.list = list;
    }

    public static void main(String[] args) {
        try {
   /*         Class<?> c = Class.forName("res15.ImplementClass");
            Constructor<?> constructor = c.getConstructor(String.class, List.class);
            List<String> names=new ArrayList<>();
            names.add("123321");
            names.add("sds");
            ImplementClass sun = (ImplementClass) constructor.newInstance("sun", names);
            for (String s : sun.getList()) {
                System.out.println(s);
            }
            System.out.println(sun.name);*/
            String subClassName = "res15.ImplementClass";
            Class<?> classSub = Class.forName(subClassName);
            Constructor<? extends AbstratClass> newClass = classSub.asSubclass(AbstratClass.class).getConstructor(String.class, List.class);
            List<String> names=new ArrayList<>();
            names.add("123321");
            names.add("sds");
            AbstratClass anme = newClass.newInstance("anme", names);
            System.out.println(anme.name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }


}
