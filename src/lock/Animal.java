package lock;

/**
 * Created by jiangbenpeng on 22/02/2017.
 * @see <http://www.cnblogs.com/Evil-Rebe/p/5893283.html>synchronized内置锁的可重入性和分析总结</http://www.cnblogs.com/Evil-Rebe/p/5893283.html>
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Animal {

    public synchronized void eat() {
        System.out.println("animal eat");
    }

    public static class Cat extends Animal {

        public synchronized void eat() {
            System.out.println("cat eat");
            super.eat();
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();

    }
}
