package builder;

import java.awt.*;

/**
 * @author ken
 * @date 2019/5/14  20:13
 * @description  建造者模式,优势是是规范流程，同时又对用户屏蔽了实现的细节
 */
public abstract class PersonBuilder  {

   protected abstract  void head();
   protected abstract  void hand();
   protected abstract  void leg();
   protected abstract  void  body();




}
