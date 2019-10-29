package res15;

/**
 * @author ken
 * @date 2019-4-1  11:36
 * @description
 */
public abstract class Leader {


    protected   String name ;

    protected   Leader leader;

    public abstract void handle(Request request);

    public  abstract void nextLeader(Leader leader);

    public Leader() {
    }

    public Leader(String name) {
        this.name = name;
    }
}
