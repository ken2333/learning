package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2019/5/14  20:45
 * @description 通知者
 */
public abstract class Informer {

public  List<Observer> list=new ArrayList<>();
    /*添加观察者*/
 public    void   add(Observer observer){
     list.add(observer);
 };

 public     void move(Observer observer){
     list.remove(observer);
 }

 public void update()
 {
     for (Observer observer : list) {
         observer.update();
     }
 }




}
