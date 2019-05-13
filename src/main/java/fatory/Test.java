package fatory;

/**
 * @author ken
 * @date 2019/5/11  23:33
 * @description
 */
public class Test {

    public static void main(String[] args) {

        Fatory<Integer> fatory=new MultiplicationFatory();
        Calculate<Integer> fatory1 = fatory.getFatory(10, 2);
        System.out.println(fatory1.getretsult());

    }
}
