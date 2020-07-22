package nio.cheat;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/11
 */
public class ClientTest3 {


    public static void main(String[] args) throws IOException {
        Client client = new Client(new InetSocketAddress(8080),"小刚");

        client.start();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String next = sc.next();
            if (StringUtils.isNotBlank(next))
                client.write(next,Client.publicCode);

        }

    }

}
