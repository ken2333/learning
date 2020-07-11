package excle.relation;

import com.google.common.collect.BiMap;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/02
 */
public abstract class TableConfig {

    /**
     * 表的关系映射
     */
    private BiMap fieldRelationMap;

    /**
     * 表名
     */
    private String tableName;

    /**
     *  sheetindex
     */
    private int sheetIndex;

    /**
     * 数据开始的行数
     */
    private int  startColumnIndex;


    public TableConfig(BiMap fieldRelationMap, String tableName) {
        this.fieldRelationMap = fieldRelationMap;
        this.tableName = tableName;
    }

    public void config(BiMap fieldRelationMap) {
        this.fieldRelationMap = fieldRelationMap;
    }


}
