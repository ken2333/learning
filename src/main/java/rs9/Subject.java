package rs9;

import java.util.HashMap;
import java.util.Map;

public abstract class Subject {

    protected Map<String,Observers> hashMap=new HashMap<>();

    public    int add(String name,Observers observers)
    {
        Observers put = hashMap.put(name, observers);
        if (put!=null) {
            return 1;
        }
        else
            return 0;
    };

    public    void remove(String observers){
        hashMap.remove(observers);
    }

    public abstract void notifyall();



}
