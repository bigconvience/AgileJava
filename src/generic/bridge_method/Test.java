package generic.bridge_method;

/**
 * Created on 2016/1/31.
 *
 * @author benpeng.jbp
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
        Integer x = mn.data; // Causes a ClassCastException to be thrown.
    }
}
