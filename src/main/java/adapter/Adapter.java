package adapter;

/**
 * @author ken
 * @date 2019/5/18  23:12
 * @description  适配器必须实现公共的接口，然后在内部管理一个需要适配器的类的成员变量
 * ，之后再调用公共的方法时，实际调用的是需要适配的成员的方法
 */
public class Adapter implements  CommonInterface {

    private  SpecialClass speical;

    public Adapter(SpecialClass speical) {
        this.speical = speical;
    }

    @Override
    public void dosoming() {
            speical.doSpecial();
    }
}
