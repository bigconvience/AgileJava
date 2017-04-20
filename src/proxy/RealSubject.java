package proxy;

/**
 * Created by jiangbenpeng on 31/03/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
