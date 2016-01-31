package generic.type_safety;

/**
 * Created on 2016/1/30.
 *
 * @author benpeng.jbp
 * @version 1.0.0
 */
public class Test1 {
    public void main(String[] args) {
        Pair pair = new Pair<>("James", "Jiang");
        String first = (String) pair.getFirst();
        System.out.println("first: " + first);
    }
}
