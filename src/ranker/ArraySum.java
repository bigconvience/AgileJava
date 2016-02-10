package ranker;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jiangbenpeng on 2/8/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        String line = stdin.nextLine();
        int count = Integer.valueOf(line);
        for (int i = 0; i < count; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j <  count - i - 1; j++) {
                stringBuilder.append(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                stringBuilder.append("#");
            }
            System.out.println(stringBuilder.toString());
        }


    }
}
