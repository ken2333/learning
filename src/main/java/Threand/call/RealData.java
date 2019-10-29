package Threand.call;

import java.util.concurrent.Callable;

/**
 * @author ken
 * @date 2019/3/9  22:10
 * @description
 */
public class RealData implements Callable<String> {

private String par;

    public RealData(String par) {
        this.par = par;
    }

    @Override
    public String call() throws Exception {

        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<20;i++)
        {
        buffer.append(par);
        }
        Thread.sleep(2000);

        return buffer.toString();
    }
}
