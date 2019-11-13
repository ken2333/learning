package thread.chapter5.future;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author ken
 * @date 2019/11/13  22:05
 * @description
 */
public class RealData implements  Data {
    public String  result;

    public  String para;

    @Override
    public String getResult() {

        return  this.result;
    }

    public RealData(String para) {
        this.result=para;
        try {
            //这里是比较花费时间的处理
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
