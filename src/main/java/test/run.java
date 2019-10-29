package test;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ken
 * @date 2019-5-24  14:33
 * @description
 */
public class run {
    public static void copyFiles(String path1) throws IOException {
        System.out.println("请输入存放的位置，例如 d:/tem");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            if (!file.mkdirs()) {
                System.out.println("创建失败，确认是否存在相应的盘符");
                return ;
            }
        }
        InputStream inputStream = new FileInputStream(path1);
        InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bf = new BufferedReader(reader);
        String tem;
        List<String> list = new ArrayList<>();
        while ((tem = bf.readLine()) != null && tem.length() > 0) {
            File file1 = new File(tem);
            if (file1.exists()) {
                InputStream teminputstring = new FileInputStream(file1);
                byte[] bytes = new byte[1024];
                int count = 0;
                String newpaht = path + file1.getParent().substring(2);
                File temfile = new File(newpaht);
                if (!temfile.exists()) {
                    temfile.mkdirs();
                }
                FileOutputStream outputStream = new FileOutputStream(newpaht + "\\" + file1.getName());
                while ((count = teminputstring.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, count);
                }
                if (teminputstring != null) {
                    teminputstring.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } else {
                list.add(tem);
            }

        }
        if (list.size() > 0) {
            Writer writer = new FileWriter(path + "/result.txt");
            BufferedWriter bfwrit = new BufferedWriter(writer);
            for (String s : list) {
                bfwrit.write(s + "\n");
            }
            if (bfwrit != null) {
                bfwrit.close();
            }
            if (writer != null) {
                writer.close();
            }
        } else {
            System.out.println("所有的文件都存在而且复制好了");
        }
    }

    public static void main(String[] args) throws IOException {
        copyFiles("F:\\ideaSpace\\Learning\\src\\main\\java\\test\\丢失的手写意见以及路径.txt");
        copyFiles("F:\\ideaSpace\\Learning\\src\\main\\java\\test\\丢失的附件路径以及附件名称.txt");
    }


}
