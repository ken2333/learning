package strategy;

/**
 * @author ken
 * @date 2019/5/10  0:17
 * @description
 */
public class ContextStrategy  {

   private   CashStrategy cashStrategy;

    public ContextStrategy(CashStrategy cashStrategy) {
        this.cashStrategy = cashStrategy;
    }


    public double getResult(double money)
    {
        return cashStrategy.acceptCash(money);
    }

}
