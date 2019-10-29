package Threand.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2019/3/8  12:40
 * @description
 */
public class ArrayBlocking<T> {

    private static ReentrantLock lock=new ReentrantLock();

    private static Condition notEmpty=lock.newCondition();

    private static Condition notFull=lock.newCondition();

    private int size=10;

    private  Object arr=new Object[size];


}
