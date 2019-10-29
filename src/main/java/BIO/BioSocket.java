package BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ken
 * @date 2019/3/10  10:43
 * @description
 */
public class BioSocket {
    private  static  class  runnable implements Runnable
    {
        private Socket socket;

        public runnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader bufferedReader=null;
            try {
                  bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                char[] chars=new char[1024];
                int count=0;
                while((count=bufferedReader.read(chars))!=-1)
                {
                    System.out.println("接收到："+new String(chars,0,count));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (bufferedReader!=null)
                        bufferedReader.close();
                   if (!socket.isClosed())
                       socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket=new ServerSocket(8080);
        while(true)
        {
            Socket accept = serverSocket.accept();
            executorService.execute(new runnable(accept));
        }
    }
}
