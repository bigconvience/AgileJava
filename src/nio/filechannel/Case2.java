package nio.filechannel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by jiangbenpeng on 16/02/2017.
 *
 * http://blog.csdn.net/totogogo/article/details/3123117 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Case2 {
    private static final String filename = "tmp.csv";

    static public void main( String args[] ) throws Exception {

        File f = new File(filename);
        RandomAccessFile raf = null;

        System.out.println("**************Test lock method************");
        try {
            raf = new RandomAccessFile(f, "rw");
            FileChannel fc = raf.getChannel();
            FileLock fl = fc.lock();
            System.out.println("locked");
            if (fl.isValid()) {
                fl.release();
                System.out.println("release lock");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (raf != null)
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
