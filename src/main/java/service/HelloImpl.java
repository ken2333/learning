package service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2018-11-26  16:02
 * @description
 */
@WebService
public class HelloImpl  implements  Hello{
    @Override
    public String hello() {

        System.out.println("执行了服务");
        return  "hello world";
    }

    @Override
    public List<String> getList() {

            List<String> list=new ArrayList<>();
                list.add("123343");
                list.add("32121");
                return  list;
        }

}
