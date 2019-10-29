package Threand;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2019/3/6  15:55
 * @description 公平锁和非公平锁
 */
public class fairLock  {

    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
