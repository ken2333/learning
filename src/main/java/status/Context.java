package status;

/**
 * @author ken
 * @date 2019/5/16  23:49
 * @description
 */
public class Context {

    private  Status status;

    public Context(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void request( )
    {
        this.status.handble(this);
    }
}
