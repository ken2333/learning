package unity;
import org.apache.commons.io.FileUtils;

import java.io.File;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author ken
 * @date 2018-12-8  17:39
 * @description
 */
public class dumpFileCheck {


    private  static  HashMap<String,List<File>> map=new HashMap<>();
    public static void main(String[] args) {
        String path="C:\\Users\\ken\\Desktop\\12_25";
        Collection<File> files = FileUtils.listFiles(new File(path), null, true);
        for(File file:files)
        {
            if(file.isDirectory())
                continue;
            List<File> files1 = map.get(file.getName());
            if(files1==null||files1.size()==0)
            {
                List<File> tem = new ArrayList<>();
                tem.add(file);
                map.put(file.getName(),tem);
            }
            else
            {
                map.get(file.getName()).add(file);
            }
        }
        Collection<List<File>> values = map.values();
        for(List<File> arrayList:values)
        {
            if(arrayList.size()>1)
            {
               for(File file:arrayList)
               {
                   System.out.println(file.getAbsolutePath().substring(path.length()+1)+"  "+
                           LocalDateTime.ofEpochSecond(file.lastModified()/1000,0,ZoneOffset.ofHours(8)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
               }
                System.out.println("----------------------------------");
            }
        }

    }
}
