package disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author ken
 * @date 2019/3/10  19:28
 * @description
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return  new PCData();
    }


}
