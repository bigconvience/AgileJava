package generic.wildcards;

import java.util.List;

/**
 * Created by jiangbenpeng on 2/10/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class LowerBound {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

}
