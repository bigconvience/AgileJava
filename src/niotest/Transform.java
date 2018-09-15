package niotest;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by jiangbenpeng on 2018/9/14.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Transform {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("data/fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("data/toFile.txt", "rw");
        FileChannel      toChannel = toFile.getChannel();

        long position = 0;
        long count    = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);
    }
}
