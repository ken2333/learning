package zookeeper;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.proto.WatcherEvent;

/**
 * @author ken
 * @date 2019/10/23  23:19
 * @description
 */
public class Master  implements  Watcher {
    ZooKeeper zk;

    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    @Override
    public void process(WatcherEvent event) {
        System.out.println(event);
    }

}
