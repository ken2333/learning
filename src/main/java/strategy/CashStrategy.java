package strategy;


/*策略模式，主要根据不同的*/
public interface CashStrategy {


    //收钱的接口
    public double acceptCash(double money);
}
