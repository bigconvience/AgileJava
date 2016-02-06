package generic.inheritance;

/**
 * Created by jiangbenpeng on 2/6/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
