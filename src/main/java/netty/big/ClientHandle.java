package netty.big;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/13
 */
public class ClientHandle extends ChannelInboundHandlerAdapter {
    FileOutputStream out = null;
    FileChannel fileChannel = null;

    public ClientHandle() throws FileNotFoundException {
        out = new FileOutputStream(new File("E:\\tem\\tem"));

        fileChannel = out.getChannel();
    }

    //在通道可以就绪时出发这方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        int length = 0;
        try {
            while ((length = byteBuf.readableBytes()) > 0) {
                byteBuf.readBytes(fileChannel, 0, length);
            }
        } finally {
            byteBuf.release();
            if (length == 0) {
                out.close();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
