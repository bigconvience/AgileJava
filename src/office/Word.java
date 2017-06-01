package office;


/**
 * Created by jiangbenpeng on 21/04/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Word implements Assembly {
    static {
        System.out.println("Word static initialize");
    }

    @Override
    public void start() {
        System.out.println("Word starts");
    }
}
