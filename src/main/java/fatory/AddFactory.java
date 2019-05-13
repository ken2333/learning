package fatory;

/**
 * @author ken
 * @date 2019/5/11  23:30
 * @description
 */
public class AddFactory implements  Fatory<Integer> {



    public Calculate<Integer> getFatory(int a,int b) {

        return new AddClass(a,b);
    }

}
