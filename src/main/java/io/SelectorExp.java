package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * @author ken
 * @date 2019/10/28  21:49
 * @description
 */
public class SelectorExp {

    public static void main(String[] args) throws IOException {
        Selector selector=Selector.open();
        SocketChannel socketChannel=null;
        socketChannel.configureBlocking(false);
        SelectionKey register = socketChannel.register(selector, SelectionKey.OP_READ);
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        SelectableChannel channel = register.channel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
    }


}
