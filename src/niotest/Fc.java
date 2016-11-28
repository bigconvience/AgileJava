package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jiangbenpeng on 28/11/2016.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Fc {
    public static void main(String[] args) {
        nioRead();
        nioWrite();

    }

    private static void nioWrite() {
        FileOutputStream fout = null;
        String messageStr = "This is word, big convience";
        byte[] message = messageStr.getBytes();

        try {
            fout = new FileOutputStream("writesomebytes.txt");
            FileChannel fc = fout.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            for (int i = 0; i < message.length; ++i) {
                buffer.put(message[i]);
            }
            buffer.flip();
            fc.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nioRead() {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("readandshow.txt");
            FileChannel fc = fin.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            fc.read(buffer);

            System.out.println(buffer.get());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
