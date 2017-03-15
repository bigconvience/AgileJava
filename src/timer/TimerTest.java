package timer;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jiangbenpeng on 5/24/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class TimerTest {
    private Timer timer;
    private TimerTask timerTask;
    private int counter=0;


    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, to wake up every 1 second
        timer.schedule(timerTask, 1000, 1000); //
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                System.out.println("in timer ++++  "+ (counter++));
                if (counter == 10) {
                    System.out.println("in timer ready to stop");
                    timer.cancel();
                }
            }
        };
    }


    public static void main(String[] args) {
        new TimerTest().startTimer();
    }
}
