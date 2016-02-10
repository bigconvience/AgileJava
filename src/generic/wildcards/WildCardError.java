package generic.wildcards;

import java.util.List;

/**
 * Created by jiangbenpeng on 2/10/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class WildcardError {
    void foo(List<?> i) {
        i.set(0, i.get(0));
    }
}
