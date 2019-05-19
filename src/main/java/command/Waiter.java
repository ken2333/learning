package command;

/**
 * @author ken
 * @date 2019/5/19  20:11
 * @description
 */
public class Waiter extends  Inovker {

    @Override
    public void add(Command command) {
        list.add(command);
    }

    @Override
    public void remove(Command command) {
        remove(command);
    }
}
