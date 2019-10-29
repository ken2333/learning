package zookeeper;

import org.apache.zookeeper.proto.WatcherEvent;

/**
 * @author ken
 * @date 2019/10/23  23:18
 * @description
 */
public interface Watcher {
    void process(WatcherEvent event);
}
