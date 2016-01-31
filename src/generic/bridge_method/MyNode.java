package generic.bridge_method;

/**
 * Created on 2016/1/31.
 *
 * @author benpeng.jbp
 * @version 1.0.0
 */
public class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
