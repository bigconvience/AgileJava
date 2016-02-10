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
        int count;
        String line = stdin.nextLine();
        count = Integer.valueOf(line);
        int[] triple = new int[2 * count];

        for (int i = 0; i < count; i++) {

            line = stdin.nextLine();
            String[] tokens = line.split(" ");
            triple[2 * i] = Integer.valueOf(tokens[i]);
            triple[2 * i + 1] = Integer.valueOf(tokens[count - i - 1]);
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < count; i++) {
            sum1 += triple[2 * i];
            sum2 += triple[2 * i + 1];
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
