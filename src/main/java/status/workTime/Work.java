package status.workTime;

/**
 * @author ken
 * @date 2019/5/17  0:18
 * @description
 */
public class Work  {

    private  Status status;

    private  int  hourse;

    private  boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getHourse() {
        return hourse;
    }

    public void setHourse(int hourse) {
        this.hourse = hourse;
    }

    public Work(Status status) {
        this.status = status;
        this.isFinished=false;
        this.hourse=9;
    }

    public void doWork()
    {
        this.status.handle(this);
    }
}
