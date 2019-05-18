package menento;

/**
 * @author ken
 * @date 2019/5/18  23:38
 * @description 备忘录类
 */
public class Memento {


    private  String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


}
