package BIO;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ken
 * @date 2019/3/10  11:08
 * @description
 */
public class Bioclient {

    private  static  class  runnable implements  Runnable
    {
        private Socket socket;

        public runnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            OutputStreamWriter writer=null;
            try {
                  writer = new OutputStreamWriter(socket.getOutputStream());
                writer.write("你好");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {

                    try {
                        if(writer!=null) {
                        writer.close();
                        }
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Socket socket=new Socket("127.0.0.1",8080);
        executor.execute(new runnable(socket));

    }
}
