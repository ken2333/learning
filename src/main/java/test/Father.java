package test;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/01
 */
public class Father {

    private String prvateMsg;


    public Father() {
        this.prvateMsg = "fatherName";
    }

    public Father(String prvateMsg) {
        this.prvateMsg = prvateMsg;
    }

    protected  void dosometing()
    {
        System.out.println(prvateMsg);
    }
}
