package menento;

/**
 * @author ken
 * @date 2019/5/18  23:42
 * @description 管理类
 */
public class CareTaker {
    //用于记录状态
    private  Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
