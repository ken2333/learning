package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2019/5/17  23:51
 * @description
 */
public class run {

    public static void main(String[] args) throws IOException {
        List<String>  list=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        Reader reader=new FileReader("g:\\text.txt");
        BufferedReader bf = new BufferedReader(reader);
        String str;
        while ((str=bf.readLine())!=null)
        {
            list.add(str);
        }
        bf.close();
        reader.close();
        for(int i=0;i<list.size();i++)
        {
         // String path=
          String path=list.get(i);
            File file=new File(path);
            if (!file.exists())
            {
                System.out.println(path);
                list2.add(list.get(i));
            }
        }
        FileWriter writer=new FileWriter("g:/out.txt");
        BufferedWriter bfout=new BufferedWriter(writer);
        for(int i=0;i<list2.size();i++)
        {
              writer.write(list2.get(i)+"\n");
        }
        writer.close();
        bfout.close();
        System.out.println(list2.size());
    }

}
