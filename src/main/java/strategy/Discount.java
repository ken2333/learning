package strategy;

/**
 * @author ken
 * @date 2019/5/10  0:04
 * @description 打折类
 */
public class Discount  implements  CashStrategy{

    //折扣率
    private double  discount;

    public Discount(double discount) {
        this.discount = discount;
    }

    @Override
    public double acceptCash(double money) {

        return money*discount;
    }
}
