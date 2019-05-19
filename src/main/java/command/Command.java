package command;

/*
*
*
* 命令模式，用于inovker用于接收和存储客户端发来的command，之后在通知command里面的reciver处理
* 每一个re
*
* */
public abstract class  Command {


    protected   Receiver receiver;

    public   abstract void execute();

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
}
