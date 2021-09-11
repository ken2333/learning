package thread.chapter5.future;

/**
 * @author ken
 * @date 2019/11/13  22:12
 * @description
 */
public class Client {

    public Data request(String par) {
        //一开始先创建一个对象
        FutureData futureData = new FutureData();
        //这里启用了另一个线程进行异步处理
        new Thread() {
                @Override
                public void run() {
                //构造正式的数据
                RealData realData = new RealData(par);
                // 把这个数据放入到futureData中
                futureData.setRealData(realData);
            }
        }.start();
        return futureData;
    }

    public static void main(String[] args) {
        //创建客户端，并且启动程序进行处理
        Client client = new Client();
        Data request = client.request("123321");
        //到了这里，不会真实数据的返回，而是继续的往下走，这样可以避免因为等待浪费的时间
        System.out.println("开始其他1 ");
        System.out.println("开始其他2");
        //在等待异步处理完成后既可以拿到真实的数据了
        System.out.println(request.getResult());
    }
}
