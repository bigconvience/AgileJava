package ranker;

import java.util.Scanner;

/**
 * Created by jiangbenpeng on 3/24/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Multi{
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();
        int T = stdin.nextInt();

        int[] width = new int[N];

        for (int i = 0; i < N; i++) {
            width[i] = stdin.nextInt();
        }

        for (int i = 0; i < T; i++) {
            getNumb(stdin.nextInt(), stdin.nextInt(), width);
        }

        stdin.close();
    }


    private static void getNumb(int a, int b, int[] width) {
        int min = width[a];


        for (int i = a + 1; i <= b; i++) {
           if (width[i] < min) {
               min = width[i];
           }
        }

        System.out.println(min);
    }

}
