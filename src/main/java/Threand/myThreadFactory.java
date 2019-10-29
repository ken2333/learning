package Threand;

import java.util.concurrent.ThreadFactory;

/**
 * @author ken
 * @date 2019/3/7  22:01
 * @description
 */
public class myThreadFactory  implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t=new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
