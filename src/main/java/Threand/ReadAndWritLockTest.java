package Threand;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ken
 * @date 2018-12-11  23:02
 * @description 读写锁的测试
 */
public class ReadAndWritLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock lock=new ReentrantReadWriteLock();
        Count count=new Count(123L,1000);
        Thread s=new Thread(new readAction(lock,count));
        Thread s9=new Thread(new readAction(lock,count));
        Thread s2=new Thread(new writeAction(lock,-303,count));
        Thread s3=new Thread(new readAction(lock,count));
        Thread s4=new Thread(new writeAction(lock,103,count));
        Thread s5=new Thread(new writeAction(lock,103,count));
        s.start();
        s9.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        Thread.currentThread().join(1000);
    }

}

@Data
class  Count{

    private Long id;

    private int money;

    public Count(Long id, int money) {
        this.id = id;
        this.money = money;
    }

/*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }*/
}

class writeAction implements Runnable
{
    ReadWriteLock lock;

    Lock writeLock;

    Count count;
    int money;
    public writeAction(ReadWriteLock lock,int money,Count count) {
        this.lock = lock;
        this.money=money;
        this.count=count;
        this.writeLock= lock.writeLock();
    }

    @Override
    public void run() {
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName()+"开始写");

            if(money<0&&Math.abs(money)>count.getMoney())
            {
                System.out.println("余额不足！");
            }
            count.setMoney(count.getMoney()+money);
        } finally {
            System.out.println("当前的账号余额"+count.getMoney());
            System.out.println(Thread.currentThread().getName()+  "结束写");
            writeLock.unlock();
        }

    }
}

class readAction implements Runnable
{
    private  ReadWriteLock lock;

   private  Lock readLock;

    Count count;
    int money;
    public readAction(ReadWriteLock lock,Count count) {
        this.lock = lock;
        this.count=count;
        this.readLock=lock.readLock();
    }

    @Override
    public void run() {
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName()+"开始读");
            System.out.println(Thread.currentThread().getName()+ ":" +count.getMoney());
        } finally {
            System.out.println(Thread.currentThread().getName()+"结束读");
            readLock.unlock();
        }
    }


}
