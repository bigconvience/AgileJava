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
public class Copy {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileOutputStream fout = null;
        FileInputStream fin = null;
        try {
            fout = new FileOutputStream("writesomebytes.txt");
            FileChannel fcout = fout.getChannel();
            fin = new FileInputStream("readandshow.txt");
            FileChannel fcin = fin.getChannel();

            while (true) {
                buffer.clear();
                int r = fcin.read(buffer);

                if (r == -1) {
                    break;
                }

                buffer.flip();
                fcout.write(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
