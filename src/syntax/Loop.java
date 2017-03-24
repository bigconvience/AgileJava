package syntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbenpeng on 18/03/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Loop {
    public static void main(String args[]) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }

        System.out.println(" end ");
    }
}
