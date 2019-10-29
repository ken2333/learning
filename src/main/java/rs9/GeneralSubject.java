package rs9;

import java.util.Iterator;

/**
 * @author ken
 * @date 2019-4-1  11:06
 * @description
 */
public class GeneralSubject extends  Subject {



    @Override
    public void notifyall() {
        Iterator<String> iterator = hashMap.keySet().iterator();
        while(iterator.hasNext())
        {
            String next = iterator.next();
            Observers observers = hashMap.get(next);
            observers.update();
        }
    }

}
