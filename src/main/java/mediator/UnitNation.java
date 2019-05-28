package mediator;

/**
 * @author ken
 * @date 2019/5/22  20:56
 * @description
 */
public class UnitNation implements  Mediator {

    private  Nation china;

    private Nation america;


    @Override
    public void sendto(String str, Nation nation) {

        if (china==nation)
        {
            america.notify(str);
        }
        else
        {
            china.notify(str);
        }
    }

    public void setChina(Nation china) {
        this.china = china;
    }

    public void setAmerica(Nation america) {
        this.america = america;
    }
}
