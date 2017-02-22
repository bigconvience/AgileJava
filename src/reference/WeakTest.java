package reference;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by jiangbenpeng on 21/02/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class WeakTest {
    public static void main(String[] args) {
        weakTest();

    }

    private static void weakTest() {
        Object ref = new Object();//ref是Object对象的强引用

//将一个软引用指向对象，此时Object对象有两个引用

        WeakReference sf = new WeakReference(ref);

        ref = null;//去除对象的强引用

        System.gc();//gc只有在内存不足是才会回收软引用对象

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
