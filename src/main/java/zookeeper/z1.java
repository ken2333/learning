package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @author ken
 * @date 2019/10/23  23:13
 * @description
 */
public class z1 {

    public static void main(String[] args)   {
        try {
            //获取连接
            ZooKeeper zooKeeper = new ZooKeeper("192.168.100.2:2181", 150000, new Watcher() {
                //实现观察者
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event);
                }
            });

            ZooKeeper.States state = zooKeeper.getState();
            if (state.isAlive()) {
                System.out.println("true");
                //创建一个节点,数据是test,  创建的模式是临时的
                //String s = zooKeeper.create("/master", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        //        System.out.println(zooKeeper.create("/test1", "test node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
                List<String> children = zooKeeper.getChildren("/test1", false);
                Stat data=new Stat();
                byte[] data1 = zooKeeper.getData("/test1/f1", false, data);
                System.out.println(data);
                System.out.println(new String(data1));
            } else {
                System.out.println("false");
            }

            //关闭连接
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
