package status.workTime;

/**
 * @author ken
 * @date 2019/5/17  0:26
 * @description
 */
public class EveningStatus implements  Status   {

    @Override
    public void handle(Work work) {

            System.out.println("正在努力的加班");
            if (work.isFinished()) {
                System.out.println("重要完成了工作可以下班了");

            }
            else if(work.getHourse()>=22)
            {
                System.out.println("没办法了只能明天再做了，下班");

            }


    }
}
