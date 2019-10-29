package netty.bacis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ken
 * @date 2019/3/8  13:36
 * @description
 */
public class basic2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket accept = serverSocket.accept();
 /*       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        int count=0;
        char[] chars=new char[1024];
        while ((count=bufferedReader.read(chars))!=-1)
        {
            System.out.println(new String(chars,0,count));
        }*/
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("don.duwei".getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
