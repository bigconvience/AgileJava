package generic.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbenpeng on 2/10/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Test2 {
    private static void sub() {
        List<? extends Integer> intList = new ArrayList<>();
        Integer a = new Integer(5);
        List<? extends Number> numList = intList;
    }

    public static void main(String[] args) {
        sub();
        Integer a = new Integer(5);
        Number b = a;
    }


}
