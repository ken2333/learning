package nio.NioTest;

import java.nio.ByteBuffer;

/**
 * @author ken
 * @date 2019/10/28  22:40
 * @description
 */
public class Buffers {

    private ByteBuffer readBuffer;
    private ByteBuffer writeBuffer;

    public Buffers(int i, int n) {
        this.readBuffer = ByteBuffer.allocate(i);
        this.writeBuffer = ByteBuffer.allocate(n);
    }

    public ByteBuffer getReadBuffer() {
        return readBuffer;
    }

    public ByteBuffer getWriteBuffer() {
        return writeBuffer;
    }
}
