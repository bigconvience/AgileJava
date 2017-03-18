package consumer;

import java.util.Random;

/**
 * Created by jiangbenpeng on 17/03/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class ProducerConsumer {
    static final int N = 10; // constant giving the buffer size
    static producer p = new producer(); // instantiate a new producer thread
    static consumer c = new consumer(); // instantiate a new consumer thread
    static OurMonitor mon = new OurMonitor();

    public static void main(String args[]) {
        p.setName("producer");
        c.setName("consumer");
        p.start(); // star t the producer thread
        c.start(); // star t the consumer thread
    }

    // instantiate a new monitor
    static class producer extends Thread {

        public void run() { // run method contains the thread code
            int item;
            while (true) { // producer loop
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                item = produceItem();
                mon.insert(item);
            }
        }

        private int produceItem() {
            int item = new Random().nextInt(N);
            System.out.println("produce item: " + item);
            return item;
        }
    }

    static class consumer extends Thread {
        public void run() { //run method contains the thread code
            int item;
            while (true) { // consumer loop
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                item = mon.remove();
                consumeItem(item);
            }
        }

        private void consumeItem(int item) {
            System.out.println("consume item: " + item);
        }
    }

    static class OurMonitor { // this is a monitor
        private int buffer[] = new int[N];
        private int count = 0, lo = 0, hi = 0; // counters and indices

        public synchronized void insert(int val) {
            if (count == N)
                goToSleep();
            buffer[hi] = val;
            hi = (hi + 1) % N; // slot to place next item in
            count = count + 1; // one more item in the buffer now
            if (count == 1)
                notify(); // if consumer was sleeping, wake it up
        }

        public synchronized int remove() {
            int val;
            if (count == 0)
                goToSleep();
            val = buffer[lo];
            lo = (lo + 1) % N;
            count = count - 1;
            if (count == N - 1) {
                notify();
            }
            return val;
        }

        private void goToSleep() {
            try {
                wait();
            } catch (InterruptedException exc) {
            }
        }
    }
}
