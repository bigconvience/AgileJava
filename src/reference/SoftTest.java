package reference;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * Created by jiangbenpeng on 21/02/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class SoftTest {
    public static void main(String[] args) {
    softTest();

    }

    private static void softTest() {
        Person jack = new Person("Jack");
        SoftReference<Person> personSoftReference = new SoftReference<>(jack);
        System.out.println(personSoftReference.get());
        jack = null;
        System.gc();
        System.gc();
        System.out.println(personSoftReference.get());

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
