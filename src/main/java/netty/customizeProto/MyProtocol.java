package netty.customizeProto;

/**
 * describe:自定义协议类
 *
 * @author syh
 * @date 2020/08/04
 */
public class MyProtocol {

    private int length;

    private byte[] data;

    public MyProtocol(int length, byte[] data) {
        this.length = length;
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public byte[] getData() {
        return data;
    }
}
