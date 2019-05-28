package mediator;

import com.alibaba.fastjson.JSON;

/**
 * @author ken
 * @date 2019/5/22  21:01
 * @description
 */
public class test {

    public static void main(String[] args) {
        Mediator mediator=new UnitNation() ;

        Nation america=new America(mediator);
        Nation china=new China(mediator);

        ((UnitNation) mediator).setAmerica(america);
        ((UnitNation) mediator).setChina(china);
        china.send("123");

    }
}
