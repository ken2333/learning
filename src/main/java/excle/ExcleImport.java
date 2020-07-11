package excle;

import excle.relation.TableConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class ExcleImport {


    /**
     * 读取excle的文件流,读取文件
     *
     * @return
     */
    public abstract void importFile() throws Exception;

    /**
     * 简单的检查
     *
     * @return
     */
    public abstract void simpleCheck();


    /*转化数据*/
    public abstract void parseData();


    /**
     * 保存数据
     */
    public abstract void saveData();


    /**
     *
     */
    public void porsses() {
        try {
            importFile();
            simpleCheck();
            parseData();
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
