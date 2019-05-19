package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2019/5/19  20:02
 * @description
 */
public  abstract   class Inovker {

    List<Command> list=new ArrayList<>();


    public abstract void add(Command command);


    public abstract void remove(Command command);

     public void notifyAllReceiver(){
         for (Command command : list) {
             command.execute();
         }
     }
}
