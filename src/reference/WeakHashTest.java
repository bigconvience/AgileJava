package reference;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by jiangbenpeng on 21/02/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class WeakHashTest {
    public static void main(String[] args) {
        testWeakHashMap();
    }

    private static void testWeakHashMap() {

        int M1 = 1024;
        Object o = new Object();
        Map<byte[], Object> map = new WeakHashMap<>();

        ArrayList<byte[]> bytes1 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[M1];
            if (i % 2 == 0) {
                bytes1.add(bytes);
            }
            map.put(bytes, o);
            bytes = null;
        }
        System.out.println("before gc map.size:" + map.size());
        System.gc();
        try {
            //waiting for gc
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after gc map.size:" + map.size());
    }
}
