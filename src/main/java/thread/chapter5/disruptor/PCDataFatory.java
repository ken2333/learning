package thread.chapter5.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * describe: 工厂类
 *
 * @author syh
 * @date 2019/11/12
 */
public class PCDataFatory  implements EventFactory<PCData> {


    @Override
    public PCData newInstance() {

        return  new PCData();
    }
}
