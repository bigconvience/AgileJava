package generic.bound;

/**
 * Created by jiangbenpeng on 2/6/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class MultiBounds {
    static class A {
        public void a() {

        }
    }

    interface B {
        void b();
    }

    interface C {
        void c();
    }


    static class D <T extends A & B & C> {
        public void d(T t) {
            t.a();
            t.b();
            t.c();
        }
    }

    public static void main(String[] args) {
        D d = new D();
        d.d(new A());
    }
}
