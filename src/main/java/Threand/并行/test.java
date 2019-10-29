package Threand.并行;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ken
 * @date 2019/3/9  22:29
 * @description
 */
public class test {
    public static  class  msg
    {
        private double  i;
        private double  m;

        public msg(double i, double m) {
            this.i = i;
            this.m = m;
        }

        public double getI() {
            return i;
        }

        public double getM() {
            return m;
        }
    }

    //乘法

    public static  class run1 implements  Runnable
    {
        private BlockingDeque<msg> bq=new LinkedBlockingDeque<>();
        @Override
        public void run() {

        }
    }

}
