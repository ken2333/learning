package thread.chapter2;

/**
 * @author ken
 * @date 2019/10/29  22:04
 * @description 一个简单的Thread.currentThread().isInterrupted函数的使用
 */
public class InterruptTest {

    public static class R1 implements Runnable {
        private int count;

        public R1(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            int tem = 0;
            //这里判断是否被打断,如果有被打断了,退出执行代码
            while (!Thread.currentThread().isInterrupted()) {
                tem++;
                if (tem == count) {
                    //当执行到一定的次数标记中断
                    Thread.currentThread().interrupt();
                    System.out.println("打断程序");
                } else {
                    try {
                        System.out.println("休眠" + tem);
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        R1 r1 = new R1(100);
        Thread thread = new Thread(r1);
        thread.start();
    }
}
