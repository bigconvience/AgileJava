package generic.bound;

/**
 * Created by jiangbenpeng on 2/6/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class GenericAlgorithm {


    public interface Comparable<T> {
        public int compareTo(T o);
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }


}
