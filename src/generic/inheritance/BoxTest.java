package generic.inheritance;

/**
 * Created by jiangbenpeng on 2/6/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class BoxTest {
    public static void boxTest(Box<Number> box) {
        System.out.println(box.get());
    }


    public static void main(String[] args) {
        Box<Number> box = new Box<>();
        box.set(7);
        boxTest(box);

        Box<Integer> box1 = new Box<>();
        box1.set(8);
       // boxTest(box1);
    }
}
