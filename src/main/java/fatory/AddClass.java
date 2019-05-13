package fatory;

/**
 * @author ken
 * @date 2019/5/11  23:24
 * @description
 */
public class AddClass implements  Calculate<Integer> {

    private Integer a;

     private  Integer b;

    public AddClass(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer getretsult() {
        return a+b;
    }
}
