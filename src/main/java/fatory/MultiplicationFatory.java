package fatory;

/**
 * @author ken
 * @date 2019/5/11  23:26
 * @description
 */
public class MultiplicationFatory implements Fatory<Integer> {




    @Override
    public Calculate<Integer> getFatory(int a, int b) {
        return  new Multiplication(a,b);
    }
}
