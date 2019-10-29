package rs9;

/**
 * @author ken
 * @date 2019-4-1  11:08
 * @description
 */
public class GeneralObservers implements  Observers {
    private String name;

    public GeneralObservers(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name +" 更新了");
    }
}
