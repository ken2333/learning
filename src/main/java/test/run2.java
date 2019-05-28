package test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2019/5/17  23:51
 * @description
 */
public class run2 {

    public static void main(String[] args) throws IOException {
        //路径文件
        String inpath="E:/temp/test.txt";
        //输出目录
        String outpath="E:/temp/out.txt";
        List<String>  list=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        InputStream inputStream=new FileInputStream(inpath);
        InputStreamReader reader=new InputStreamReader(inputStream,"utf-8");
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

          String path=list.get(i);
            File file=new File(path);
            if (file.exists())
            {
                boolean delete = file.delete();
                if (!delete) {
                    list2.add("文件删除失败:"+list.get(i));
                }
            }
            else
            {
                System.out.println(path);
                list2.add("文件不存在:"+list.get(i));
            }
        }
        FileWriter writer=new FileWriter(outpath);
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
