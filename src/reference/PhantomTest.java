package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * Created by jiangbenpeng on 2019-03-14.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class PhantomTest {
    public static void main(String[] args) {

        try {
            test1();
        } catch (Exception ex) {

        }
    }

    public static boolean isRun = true;

    /**
     * https://blog.csdn.net/u013263323/article/details/47361151
     */
    public static void test1() throws Exception {
        //这就是一个强引用
        String str = new String("hello");
        System.out.println(str.getClass() + "@" + str.hashCode());

        ReferenceQueue<? super String> q = new ReferenceQueue<String>();


        //现在我们由上面的强引用创建一个虚引用,所以现在str有两个引用指向它
        PhantomReference<String> p = new PhantomReference<String>(str, q);

        System.out.println(p.get());
        //可以使用get()得到引用指向的对象
        System.out.println(q.poll());//输出null


        str = null;
        Thread.currentThread().sleep(3000);
        System.gc();
        Thread.currentThread().sleep(3000);
        System.out.println(q.poll());//输出null
        isRun = false;
    }

    public static void checkQueue(ReferenceQueue referenceQueue) {
        new Thread() {
            public void run() {
                while (isRun) {
                    Object obj = referenceQueue.poll();
                    if (obj != null) {
                        try {
                            Field rereferent = Reference.class
                                    .getDeclaredField("referent");
                            rereferent.setAccessible(true);
                            Object result = rereferent.get(obj);
                            System.out.println("gc will collect："
                                    + result.getClass() + "@"
                                    + result.hashCode() + "\t"
                                    + (String) result + "reference: " + obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    /**
     * https://blog.csdn.net/imzoer/article/details/8044900
     *
     * @throws Exception
     */
    public static void test() throws Exception {
        String abc = new String("abc");
        System.out.println(abc.getClass() + "@" + abc.hashCode());

        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();

        checkQueue(referenceQueue);

        PhantomReference<String> abcWeakRef = new PhantomReference<String>(abc,
                referenceQueue);
        abc = null;
        Thread.currentThread().sleep(3000);
        System.gc();
        Thread.currentThread().sleep(3000);
        isRun = false;
    }
}
