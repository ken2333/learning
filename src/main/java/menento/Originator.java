package menento;

/**
 * @author ken
 * @date 2019/5/18  23:34
 * @description 发起人
 */
public class Originator {

    private  String state;

    public void show()
    {
        System.out.println(this.state);
    }

    public Memento createMemento()
    {
        return new Memento(this.state);
    }

    public  void setMemento(Memento memento)
    {
        this.state=memento.getState();
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
