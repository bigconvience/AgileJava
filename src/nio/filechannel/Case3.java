package nio.filechannel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by jiangbenpeng on 16/02/2017.
 *
 * http://blog.csdn.net/totogogo/article/details/3123117 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Case3 {
    private static final String filename = "tmp.csv";

    static public void main( String args[] ) throws Exception {

       // testLockInSameThread();

        testLockInDifferentThread();
    }

    public static void testLockInSameThread() {
        System.out
                .println("*********************Test lock in the same thread***************");
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(filename, "rw");
            FileChannel fc1 = raf1.getChannel();
            raf2 = new RandomAccessFile(filename, "rw");
            FileChannel fc2 = raf2.getChannel();
            System.out.println("Grabbing first lock");
            fc1.lock();
            System.out.println("Grabbing second lock");
            fc2.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
                if (raf2 != null)
                    raf2.close();
            } catch (Exception e) {
            }
        }
        System.out.println("Exiting");
    }

    public static void testLockInDifferentThread() throws Exception {
        System.out
                .println("*********************Test lock in the different thread***************");
        RandomAccessFile raf1 = new RandomAccessFile(filename, "rw");
        FileChannel fc1 = raf1.getChannel();
        System.out.println("Grabbing first lock");
        fc1.lock();
        new Thread() {
            public void run() {
                RandomAccessFile raf2;
                try {
                    raf2 = new RandomAccessFile(filename, "rw");
                    FileChannel fc2 = raf2.getChannel();
                    System.out.println("Grabbing second lock");
                    fc2.tryLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("Done");
    }
}
