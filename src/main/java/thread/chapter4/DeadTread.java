package thread.chapter4;

/**
 * @author ken
 * @date 2019/11/10  0:01
 * @description 死锁的相关测试
 */
public class DeadTread {

    private  static  Object ob1=new Object();
    private  static  Object ob2=new Object();
    private static class R1 implements Runnable {
        private  String name;

        public R1(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            //首先mimi获取ob1锁，之后获取ob2锁
            if(name.equals("mimi"))
            {
                synchronized (ob1)
                {
                    System.out.println(name+"获得锁1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ob2)
                    {
                        System.out.println(name+"获得锁2");
                        System.out.println(name+"开始执行");
                    }
                }
            }else{
                //ken首先获取ob2锁，之后在获取ob1锁
                synchronized (ob2)
                {
                    System.out.println(name+"获得锁2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ob1)
                    {
                        System.out.println(name+"获得锁1");
                        System.out.println(name+"开始执行");
                    }
                }

            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new R1("ken"),"ken");
        Thread thread2=new Thread(new R1("mimi"),"mimi");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
