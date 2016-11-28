package guava.chapter2.joiner;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbenpeng on 9/20/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class JoinerExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Foo");
        stringList.add("Bar");
        stringList.add(" ");
        stringList.add("Baz");

        String str = Joiner.on("|").skipNulls().join(stringList);
        System.out.println(str);
    }
}
