package command;

/**
 * @author ken
 * @date 2019/5/19  20:10
 * @description
 */
public class test {

    public static void main(String[] args) {

        Receiver receiver=new Receiver();
        Command commanda=new CommandA(receiver);
        Command commandab=new CommandB(receiver);
        Waiter waiter=new Waiter();
        waiter.add(commanda);
        waiter.add(commandab);
        waiter.notifyAllReceiver();

    }
}
