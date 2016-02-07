package generic.type_inference;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jiangbenpeng on 2/7/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Test1 {
    public static void main(String[] args) {
        Serializable s = pick("d", new ArrayList<String>());
    }

    static <T> T pick(T a1, T a2) { return a2; }
}
