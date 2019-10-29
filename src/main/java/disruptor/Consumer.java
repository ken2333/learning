package disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @author ken
 * @date 2019/3/10  19:24
 * @description
 */
public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData event) throws Exception {

        System.out.println(Thread.currentThread().getName()+",envent:"+event.getValue());

    }
}
