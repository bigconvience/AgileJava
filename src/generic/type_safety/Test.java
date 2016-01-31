package generic.type_safety;

/**
 * Created on 2016/1/30.
 *
 * @author benpeng.jbp
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("James", "Jiang");
        String first = pair.getFirst();
        System.out.println("first: " + first);
    }
}
