package strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ken
 * @date 2019/5/10  0:12
 * @description
 */
public class Integration  implements CashStrategy{

    private   static Map<String,Integer> map=new HashMap<>();

     private  String  userName;


    public Integration(String userName) {
        this.userName = userName;
    }

    public static Map<String, Integer> getMap() {
        return map;
    }
    @Override
    public double acceptCash(double money) {

        if (map.containsKey(userName)) {
            Integer integer = map.get(userName);
            map.put(userName,integer+(int)money);
        }
        else
        {
            map.put(userName,(int)money);
        }
        return money;
    }
}
