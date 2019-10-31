package thread.chapter2;

/**
 * @author ken
 * @date 2019/10/30  22:42
 * @description 守护线程测试
 *  在Java中的线程分为守护线程和用户线程,守护线程是为用户线程服务的,如果用户线程全部结束了,只剩下守护线程的话,程序
 *  会自动的停止
 *
 */
public class DaemonTest {

    public  static  class  R1 implements  Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                System.out.println("存活着");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new R1());
        //设置线程是守护线程
        //如果不是守护线程,会一直的运行下去,因为while(true)
        t1.setDaemon(true);
        t1.start();
        //主线程休息2000毫秒,后就结束了,只剩下了t1守护线程,之后就会退出
        Thread.sleep(2000);


    }
}
