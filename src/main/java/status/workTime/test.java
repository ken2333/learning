package status.workTime;

/**
 * @author ken
 * @date 2019/5/17  0:34
 * @description
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        Work work =new Work(new MorningStatus());
        //早上
        work.doWork();
        //下午
        work.setHourse(13);
        work.doWork();
        work.setHourse(18);
        work.doWork();
        work.setHourse(22);
        work.doWork();


    }
}
