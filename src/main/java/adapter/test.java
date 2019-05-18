package adapter;

/**
 * @author ken
 * @date 2019/5/18  23:13
 * @description
 */
public class test {
    public static void main(String[] args) {
        CommonInterface nornalClass=new NornalClass();
        nornalClass.dosoming();
        CommonInterface adapter=new Adapter(new SpecialClass());
        adapter.dosoming();
    }
}
