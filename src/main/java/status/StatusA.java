package status;

/**
 * @author ken
 * @date 2019/5/16  23:51
 * @description
 */
public class StatusA implements  Status {

    @Override
    public void handble(Context context) {
        System.out.println("转态A");
             context.setStatus(new StatusB());
    }
}
