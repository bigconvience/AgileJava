package generic.simple_box;

/**
 * Created by jiangbenpeng on 2/19/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Test {
    private void testBox() {
        Box box = new Box();
        box.set(1);
        String a = (String) box.get();
    }
}
