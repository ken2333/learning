package mediator;

/**
 * @author ken
 * @date 2019/5/22  20:52
 * @description
 */
public class China implements  Nation {

    private  Mediator mediator;

    public China(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(String message) {
        mediator.sendto(message,this);
    }

    @Override
    public void notify(String message) {
        System.out.println("China"+message);
    }
}
