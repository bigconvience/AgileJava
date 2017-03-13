package snodge;

import com.natpryce.snodge.JsonMutator;


/**
 * Created by jiangbenpeng on 5/24/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class SnodgeTest {
    public static void main(String[] args) {
        JsonMutator mutator = new JsonMutator();

        String originalJson = "{\"x\": \"hello\", \"y\": [1,2,3]}";

        mutator.forStrings().mutate(originalJson, 10)
                .forEach(System.out::println);
    }
}
