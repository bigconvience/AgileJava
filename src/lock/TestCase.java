package lock;

import java.text.DecimalFormat;

/**
 * Created by jiangbenpeng on 27/04/2017.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class TestCase {
    public static int number;
    public static boolean isinited;
    public static void main(String[] args) {
       float srt = 1.5f;

       int first = (int)srt;
       float second = srt - first;

        DecimalFormat fnum = new DecimalFormat("##0.0");
//        String floatString = String.valueOf(second);
        String floatString =fnum.format(second);


        String display = floatString.substring(floatString.indexOf("."));

       System.out.println("first: " + first + " second: " + display);



    }
}
