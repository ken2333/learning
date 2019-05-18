package menento;

/**
 * @author ken
 * @date 2019/5/18  23:42
 * @description
 */
public class test {
    public static void main(String[] args) {
        Originator originator=new Originator();
        //设置发起人的状态
        originator.setState("On");
        //展示发起人的状态
        originator.show();

        //创建管理者
        CareTaker taker=new CareTaker();
        //创建备份
        taker.setMemento(originator.createMemento());

        //发起人的另一状态
        originator.setState("off");
        originator.show();

        originator.setMemento(taker.getMemento());
        originator.show();
    }
}
