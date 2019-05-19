package command;

/**
 * @author ken
 * @date 2019/5/19  20:09
 * @description
 */
public class CommandB extends Command {

    public CommandB(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.dosomething2();
    }
}
