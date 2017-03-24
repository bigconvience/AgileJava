package thread.priority;

/**
 * Created by jiangbenpeng on 18/03/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Priority {
    /**
     * Starts two threads and wait for them to finish.
     */
    public void setPrioritiesOnThreads() {

        Thread thread1 = new Thread(new TestThread(1));
        Thread thread2 = new Thread(new TestThread(2));

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();

        try {

            //Wait for the threads to finish
            thread1.join();
            thread2.join();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Done.");

    }

    /**
     * Starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Priority().setPrioritiesOnThreads();
    }

    class TestThread implements Runnable {

        int id;

        public TestThread(int id) {

            this.id = id;
        }

        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread" + id + ": " + i);
            }
        }
    }
}
