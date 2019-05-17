package status.workTime;

/**
 * @author ken
 * @date 2019/5/17  0:25
 * @description
 */
public class AfternoonStatus implements  Status {
    @Override
    public void handle(Work work) {
        if(work.getHourse()<18)
        {
            System.out.println("下午了，工作效率有点下降了");
        }
        else if(work.getHourse()>=18&&work.isFinished())
        {
            System.out.println("下班时间到了，工作又完成了，可以下班了");
        }
        else
        {
            System.out.println("下班时间到了，但工作又没有完成，还不能下班");
            work.setStatus(new EveningStatus());
            work.doWork();
        }
    }
}
