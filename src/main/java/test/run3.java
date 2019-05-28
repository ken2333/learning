package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ken
 * @date 2019/5/17  23:51
 * @description
 */
public class run3 {

    public static void main(String[] args) throws IOException {
      Scanner scanner=new Scanner(System.in);
        System.out.println("请输入错误文件的文件夹!例如 d:/tem");
        String s = scanner.nextLine();
        System.out.println("请输入正确附件的盘符!例如 d");
        String s2 = scanner.nextLine();
        File file=new File(s);
        if (!file.exists()||!file.isDirectory()) {
            System.out.println("路径不正确或者不是文件夹!");
            return;
        }
        Queue<File> files = getFiles(s, null);
        System.out.println("扫描的文件数"+files.size());
  /*      List<String> result=new ArrayList<>();
        List<String> result2=new ArrayList<>();
        File tem=null;
  *//*      while((tem=files.poll())!=null)
        {
            if (tem.exists()&&!tem.isDirectory()) {
                String substring = tem.getParent().substring(1);
                String  realPath=s2+substring+"\\"+tem.getName();
                File realFile=new File(realPath);
                if(realFile.exists())
                {
                    if (realFile.delete()) {
                        result.add("删除了文件: "+realFile.getAbsolutePath());
                    }
                    else
                    {
                        result2.add("删除文件失败: "+realFile.getAbsolutePath());
                    }
                }  else{
                    result2.add("文件不存在: "+realFile.getAbsolutePath());
                }
            }

        }
        Writer out=new FileWriter(s2+":/result.txt");
        BufferedWriter writer=new BufferedWriter(out);
        for (String s1 : result) {
            writer.write(s1+"\n");
        }
        if(writer!=null)
            writer.close();
        if(out!=null)
            out.close();

        Writer out2=new FileWriter(s2+":/result2.txt");
        BufferedWriter writer2=new BufferedWriter(out2);
        for (String s1 : result2) {
            writer2.write(s1+"\n");
        }
        if(writer2!=null)
            writer2.close();
        if(out2!=null)
            out2.close();*/
    }

    public static Queue<File> getFiles(String path , Queue<File> list)
    {
        if(list==null)
        {
            list=new LinkedBlockingDeque();
        }
        File file=new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
             //       getFiles(file.getAbsolutePath(),list);
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if(file1.isDirectory())
                    {
                        getFiles(file1.getAbsolutePath(),list);
                    }
                    else
                    {
                        list.add(file1);
                    }
                }
            }
        }
        return list;
    }


}
