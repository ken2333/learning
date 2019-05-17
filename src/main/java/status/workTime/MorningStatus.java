package status.workTime;

import jdk.net.SocketFlow;

/**
 * @author ken
 * @date 2019/5/17  0:22
 * @description
 */
public class MorningStatus implements Status {


    @Override
    public void handle(Work work) {
        int hourse = work.getHourse();
        if(hourse<=12)
        {
            System.out.println("早上精神好工作效率高");
        }
        else
        {
            work.setStatus(new AfternoonStatus());
            work.doWork();
        }
    }
}
