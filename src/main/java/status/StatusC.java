package status;

/**
 * @author ken
 * @date 2019/5/16  23:51
 * @description
 */
public class StatusC implements  Status {

    @Override
    public void handble(Context context) {
        System.out.println("转态C");
        context.setStatus(new StatusA());
    }
}
