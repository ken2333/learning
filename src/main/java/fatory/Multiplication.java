package fatory;

/**
 * @author ken
 * @date 2019/5/11  23:26
 * @description
 */
public class Multiplication implements Calculate<Integer> {
    private Integer a;

    private Integer b;


    public Multiplication(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer getretsult() {
        return  this.a*this.b;
    }
}
