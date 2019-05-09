package strategy;

/**
 * @author ken
 * @date 2019/5/10  0:06
 * @description 返现类
 */
public class RetrunCash implements CashStrategy {

    private double condiction;

    private double returnMoney;

    public RetrunCash(double condiction, double returnMoney) {
        this.condiction = condiction;
        this.returnMoney = returnMoney;
    }

    @Override
    public double acceptCash(double money) {
        if (condiction <= money)
            return money - (money / condiction * returnMoney);
        else
            return money;
    }
}
