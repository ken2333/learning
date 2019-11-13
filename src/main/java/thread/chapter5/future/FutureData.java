package thread.chapter5.future;




/**
 * @author ken
 * @date 2019/11/13  22:05
 * @description  这是立即返回的数据，内部存储着一个处理后的对象，如果处理完了就会进入到准备状态
 * 如果，没有处理完成就会阻塞。
 */
public class FutureData implements Data {

    RealData realData;
    boolean isReady = false;

    public synchronized void setRealData(RealData data) {
        //设置处理后的数据，这里有个很关键的点就是isReady,用于判断是否已经准备好了
        if (!isReady) {
            isReady = true;
            this.realData = data;
        }
        //通知当前这个对象的所有阻塞线程，可以运行了
        notifyAll();
    }

    @Override
    public synchronized String getResult() {

        while (!isReady) {
            try {
                //当没有准备好的时候，会进入阻塞状态，等待通知,

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
