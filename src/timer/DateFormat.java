package timer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangbenpeng on 14/06/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class DateFormat {
    public static void main(String[] args) throws Exception {
        System.out.println(getCurrentTimeStamp());
    }

    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
