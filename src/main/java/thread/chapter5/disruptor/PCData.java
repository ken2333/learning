package thread.chapter5.disruptor;

/**
 * describe:
 *
 * @author syh
 * @date 2019/11/12
 */
public class PCData {

    private long data;

    public void setData(long data) {
        this.data = data;
    }

    public PCData(long data) {
        this.data = data;
    }

    public PCData() {
    }

    public long getData() {
        return data;
    }
}
