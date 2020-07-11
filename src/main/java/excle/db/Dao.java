package excle.db;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * describe:
 *
 * @author syh
 * @date 2020/06/02
 */
public interface Dao {

    public List<Map<String, Object>> getDataTable(String tableName, String filter, Object... objects);

    public Map<String, Object> getFieldSetBySql(String tableName, String filter, Object... objects);


    public void saveFieldSet(Map<String, Object> objectMap);


}
