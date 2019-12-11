package thread.chapter5.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * describe:
 *
 * @author syh
 * @date 2019/11/12
 */
public class Comsumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData event) throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"："+event.getData());
    }
}
