package expression;

/**
 * @author ken
 * @date 2019-5-25  15:08
 * @description
 */
public class Scale extends  Expression {
    @Override
    public void excute(String key, double value) {
        String scale="";
        switch ((int)value)
        {
            case 1:{
                scale="低音";
                break;
            }
            case 2:{
                scale="中音";
                break;
            }
            case 3:{
                scale="高音";
                break;
            }
        }
        System.out.println("scale="+scale);
    }
}
