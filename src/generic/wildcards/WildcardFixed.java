package generic.wildcards;

import java.util.List;

/**
 * Created by jiangbenpeng on 2/10/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class WildcardFixed {
    void foo(List<?> i) {
        fooHelper(i);
    }


    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}
