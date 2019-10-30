package thread;

/**
 * @author ken
 * @date 2019/10/30  22:28
 * @description 线程组测试
 */
public class ThreadGroupsTest {

    public static class   ThreadGroupA  implements Runnable
    {
        @Override
        public void run() {
            String group=Thread.currentThread().getThreadGroup().getName();
            String name=Thread.currentThread().getName();
            System.out.println("所属的组群是:"+group);
            System.out.println("线程名称:"+name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group=new ThreadGroup("group1");
        Thread t1=new Thread(group,new ThreadGroupA(),"t1");
        Thread t2=new Thread(group,new ThreadGroupA(),"t2");
        t1.start();
        t2.start();
        //由于线程是动态的,所以这个值是个估量值
        System.out.println("线程组的数量"+group.activeCount());
        group.list();
        Thread.sleep(2000);
    }

}
