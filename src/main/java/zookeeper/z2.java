package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher;

import java.io.IOException;

/**
 * @author ken
 * @date 2019/10/28  23:41
 * @description
 */
public class z2 {

    private  static class Stringback implements AsyncCallback.StringCallback
    {

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
                switch (KeeperException.Code.get(rc))
                {

                }
        }
    }


    public static void main(String[] args) throws IOException {
        //获取连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.100.2:2181", 150000, new Watcher() {
            //实现观察者
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event);
            }
        });

    }
}
