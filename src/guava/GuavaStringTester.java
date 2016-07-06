package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;


/**
 * Created by jiangbenpeng on 7/6/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class GuavaStringTester {
    public static void main(String[] args) {
        System.out.println(join());

        split();
    }

    private static String join() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        return joiner.join("Harry", null, "Ron", "Hermione");
    }

    private static void split() {
        Iterable<String> strings =  Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
        System.out.println(strings);

    }
}
