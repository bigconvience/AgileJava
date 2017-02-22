package reference;

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
public class ReferenceQueueTest {
    public static void main(String[] args) {
//    softTest();
//        testReferenceQueue2();
        testWeakHashMap();
    }

    private static void softTest() {
        Object ref = new Object();//ref是Object对象的强引用

        System.out.println(ref);

        ReferenceQueue rq = new ReferenceQueue();//有强引用的ReferenceQueue

        WeakReference sf = new WeakReference(ref, rq);//构造弱引用时传入ReferenceQueue

        System.out.println(sf);

        ref = null;//去除对象的强引用，在这里加个断点，进行调试

        System.gc();//gc对弱引用对象进行回收

        System.out.println(rq.poll());
    }

    private static void testReferenceQueue1() {
        ReferenceQueue<Object> weakReferenceReferenceQueue = new ReferenceQueue<>();

        int M1 = 1024;
        Object o = new Object();
        Map<WeakReference<byte[]>, Object> map = new HashMap<>();

        //创建一个线程监听回收的对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int cnt = 0;
                    WeakReference<byte[]> k;
                    while ((k = (WeakReference) weakReferenceReferenceQueue.remove()) != null) {
                        System.out.println((cnt++) + "recycle:" + k + "," + k.get());
                        System.out.println("worker map.size:" + map.size());
                    }

                } catch (InterruptedException e) {
                    //结束循环

                }
            }
        }).start();

        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[M1];
            map.put(new WeakReference<>(bytes, weakReferenceReferenceQueue), o);
        }
        System.gc();
        System.out.println("main map.size:" + map.size());
    }

    private static void testReferenceQueue2() {
        ReferenceQueue<Object> weakReferenceReferenceQueue = new ReferenceQueue<>();

        int M1 = 1024;
        Object o = new Object();
        Map<WeakReference<byte[]>, Object> map = new HashMap<>();

        //创建一个线程监听回收的对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int cnt = 0;
                    WeakReference<byte[]> k;
                    while ((k = (WeakReference) weakReferenceReferenceQueue.remove()) != null) {
                        map.remove(k); //在这里我们移除被回收对象的引用
                        System.out.println((cnt++) + "recycle:" + k);
                        System.out.println("worker map.size:" + map.size());
                    }


                } catch (InterruptedException e) {
                    //结束循环

                }
            }
        }).start();

        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[M1];
            map.put(new WeakReference<>(bytes, weakReferenceReferenceQueue), o);
        }
        System.gc();
        System.out.println("main map.size:" + map.size());
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
        System.out.println("after gc map.size:" + map.size());
    }
}
