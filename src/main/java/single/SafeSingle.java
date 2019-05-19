package single;

/**
 * @author ken
 * @date 2019/5/19  19:05
 * @description 这是一个线程安全的单例模式，
 */
public class SafeSingle {

    private SafeSingle single;


    private SafeSingle() {

    }

    public SafeSingle newInstance() {
        if (single == null) {   //为什么这里有两个sigle==null的判断呢？
            // 因为在加锁后第一个线程生成了实例后，为了保证之后的线程不会再继
            // 续的创建第二个实例，所有加了一个single判断
            synchronized (this)
            {
                if(single==null)
                    return new SafeSingle();
                else
                    return single;
            }
        }
        else
            return single;
    }
}
