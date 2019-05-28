package mediator;

/**
 * @author ken
 * @date 2019/5/22  20:56
 * @description
 */
public class America implements  Nation {
    private  Mediator mediator;


    public America(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void send(String message) {
        mediator.sendto(message,this);
    }

    @Override
    public void notify(String message) {
        System.out.println("America"+message);
    }
}
