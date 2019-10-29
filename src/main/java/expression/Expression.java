package expression;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ken
 * @date 2019-5-25  14:55
 * @description
 */
public abstract class Expression {

    public void Interpret(PlayContext context) {
        if (StringUtils.isEmpty(context.getText())) {
            return;
        } else {
            String palyKey=context.getText().substring(0,1);
            context.setText(context.getText().substring(2));
            double palyValue=Double.valueOf(context.getText().substring(0,context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ")+1));
            excute(palyKey,palyValue);
        }
    }

    public abstract  void excute(String key ,double value);
}
