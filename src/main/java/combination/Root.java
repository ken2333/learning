package combination;


/*组合模式*/
public interface Root {

    public void add(Root root);

    public  void remove(Root root);

     public void show();

     public  void handle();
}
