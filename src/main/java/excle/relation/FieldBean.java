package excle.relation;

import org.apache.poi.ss.formula.functions.T;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/02
 */
public abstract class FieldBean {

    /**
     * 是否必要 ,如果是必要的话，不能为空
     */
    private boolean require = false;

    /**
     * excle列表名称
     */
    private String columnName;

    /**
     * 数据表的列名
     */
    private String tableColumnName;


    /**
     * 这个是转化的方法，一般在保存到数据库的时候需要转化，例如：是 对应 1，否对应 数字0。
     */
    public abstract T parseValueToDb(T value);

    /**
     * 这个是转化的方法，一般在从数据库到展示的时候需要，例如：是 对应 1，否对应 数字0。
     */
    public abstract T parseValueToExcle(T value);


    /**
     * 校验数值是否正确
     *
     * @param value
     * @return
     */
    public abstract boolean verify(T value);
}
