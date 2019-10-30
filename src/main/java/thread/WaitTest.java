package thread;

/**
 * @author ken
 * @date 2019/10/29  22:28
 * @description 如何使用ob.wait() 和
 */
public class WaitTest {
    public static class R1 implements Runnable {
        private Object ob;

        private String name;

        public R1(Object ob, String name) {
            this.ob = ob;
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (ob) {
                System.out.println("线程" + name + "获取了对象");
                try {
                    ob.wait();
                    System.out.println("线程" + name + "开始执行了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }


        }
    }

    public static class R2 implements Runnable {
        private Object ob;

        private String name;

        public R2(Object ob, String name) {
            this.ob = ob;
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (ob) {
                System.out.println("线程" + name + "获取了对象");
                ob.notify();
                System.out.println("线程" + name + "提示了对象");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object ob=new Object();
        Thread t1=new Thread(new R1(ob,"a"));
        Thread t2=new Thread(new R2(ob,"b"));
        t1.start();
        Thread.sleep(2000);
        t2.start();


    }
}
