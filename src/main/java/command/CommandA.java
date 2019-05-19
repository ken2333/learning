package command;

/**
 * @author ken
 * @date 2019/5/19  20:09
 * @description
 */
public class CommandA  extends  Command{
    public CommandA(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.dosomething1();
    }
}
