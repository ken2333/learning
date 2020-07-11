package excle.relation.impl;

import excle.relation.FieldBean;
import org.apache.poi.ss.formula.functions.T;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/02
 */
public class FEfieldBean extends FieldBean {

    private  String parseName;

    @Override
    public T parseValueToDb(T value) {
        if(parseName==null)
            return value;
        else {

            return value;
        }
    }

    @Override
    public T parseValueToExcle(T value) {
        return value;
    }

    @Override
    public boolean verify(T value) {
        return false;
    }
}
