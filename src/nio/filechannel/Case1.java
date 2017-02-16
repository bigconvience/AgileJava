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
public class Case1 {
    private static final String filename = "tmp.csv";

    static public void main( String args[] ) throws Exception {
        File f = new File(filename);
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(f, "rw");
            FileChannel fc = raf.getChannel();
            FileLock fl = fc.tryLock();
            if (fl.isValid()) {
                System.out.println("fl valid");
                // do something here, use notepad to modify and try to save the
                // lock file, Fail!
                Thread.sleep(10000);
                fl.release();
                System.out.println("release lock");
            } else {
                System.out.println("fl locked");
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
