package niotest.socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by jiangbenpeng on 2018/9/18.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class RedisClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1111);
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);


        // 创建缓冲区阅读器从键盘逐行读入数据
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        System.out.println("Unix系统: ctrl-d 或 ctrl-c 退出"
                + "\nWindows系统: ctrl-z 退出");

        String s = in.readLine();
        while (s != null) {
            sendToServer(s, crunchifyClient);
            s = in.readLine();
        }
        in.close();

        crunchifyClient.close();
    }

    private static void sendToServer(String msg, SocketChannel channel) throws IOException {
        byte[] message = msg.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        channel.write(buffer);
        buffer.clear();

    }

    private static void log(String str) {
        System.out.println(str);
    }
}
