package rs9;

import org.junit.Test;

/**
 * @author ken
 * @date 2019-4-1  11:10
 * @description
 */
public class test {
    @Test
    public void test()
    {
        GeneralSubject subject=new GeneralSubject();
        GeneralObservers observers=new GeneralObservers("1");
        GeneralObservers observers2=new GeneralObservers("2");
        GeneralObservers observers3=new GeneralObservers("3");
        GeneralObservers observers4=new GeneralObservers("4");
        subject.add("1",observers);
        subject.add("2",observers2);
        subject.add("3",observers3);
        subject.add("4",observers4);
        subject.notifyall();
    }
}
