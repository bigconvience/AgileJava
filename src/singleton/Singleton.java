package singleton;

import java.io.Serializable;

/**
 * Created by jiangbenpeng on 08/08/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Singleton implements Serializable {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
