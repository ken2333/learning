package Threand;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ken
 * @date 2018-12-10  23:59
 * @description  condition的使用实例,
 */
public class MyList {
    private   Lock lock=new ReentrantLock();

    private   Condition notEmpty=lock.newCondition();

    private   Condition notFull=lock.newCondition();

    private LinkedList<String> list;

    private int size;



    public MyList(int size) {

        this.list =new LinkedList<>();
        this.size=size;
    }


    public void add(String str) throws InterruptedException {
        try {
            lock.lock();
            if(list.size()==size)
            {
                notFull.await();
            }
            list.add(str);
            System.out.println("插入一个数"+str);
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext())
            {
                System.out.print(iterator.next()+",");
            }
            System.out.println("\n------------------------");
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public void remove( ) throws InterruptedException {
        lock.lock();
        try {
            if(list.size()==0)
            {
                notEmpty.await();
            }
            String remove = list.remove();
            System.out.println("移除数据"+remove);
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext())
            {
                System.out.print(iterator.next()+",");
            }
            System.out.println("\n------------------------");
            notFull.signal();
        } finally {
        lock.unlock();
        }
    }

    public static void main(String[] args) {

    }


}


  class  test
  {
      public static class   produce implements  Runnable{
       private    MyList list;

          public produce(MyList list) {
              this.list = list;
          }

          @Override
          public void run() {
              Random r=new Random();
              try {
                  list.add(r.nextInt()+"");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }

      static  class  comsumer implements Runnable{
          private    MyList list;

          public comsumer(MyList list) {
              this.list = list;
          }

          @Override
          public void run() {
              try {
                  list.remove();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }

      public static void main(String[] args) throws InterruptedException {

          MyList list=new MyList(5);

          for(int i=0;i<10;i++)
          {
              //创建10个生产者
              new Thread(new produce(list)).start();
          }

          for(int i=0;i<10;i++)
          {
              //创建10个消费者
              new Thread(new comsumer(list)).start();
          }


          Thread.currentThread().join(2000);


      }

  }