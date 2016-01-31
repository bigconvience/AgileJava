package generic.bridge_method;

/**
 * Created on 2016/1/31.
 *
 * @author benpeng.jbp
 * @version 1.0.0
 */
public class Node<T> {
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
