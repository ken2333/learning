package netty.groupChat.client;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/22
 */
public class Client1 {

    public static void main(String[] args) {
        NettyClient client = new NettyClient("小明",8080);
        client.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (StringUtils.isNotBlank(s))
                client.write(s);
        }
    }
}
