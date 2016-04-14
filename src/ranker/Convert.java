package ranker;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by jiangbenpeng on 3/20/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Convert {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int N = stdin.nextInt();
        stdin.nextLine();
        for (int i = 0; i < N; i++) {
            parseLine(stdin);
        }
        stdin.close();
    }

    private static void parseLine(Scanner stdin) {
        String l1 = stdin.nextLine();
        String l2 = stdin.nextLine();

        String[] l11 = l1.split(" ");
        BigInteger B = new BigInteger(l11[0]);
        BigInteger W = new BigInteger(l11[1]);

        String[] l21 = l2.split(" ");
        BigInteger X = new BigInteger(l21[0]);
        BigInteger Y = new BigInteger(l21[1]);
        BigInteger Z = new BigInteger((l21[2]));

        BigInteger result;

        BigInteger small, big;
        BigInteger small_count, big_count;

        if (X.compareTo(Y) < 0) {
            small = X;
            small_count = B;
            big = Y;
            big_count = W;
        } else {
            small = Y;
            small_count = W;
            big = X;
            big_count = B;
        }

        if (small.add(Z).compareTo(big) >= 0) {
            result = small.multiply(small_count).add(big.multiply(big_count));
        } else {
            result = small.multiply(small_count.add(big_count)).add(big_count.multiply(Z));
        }

        System.out.println(result.toString());
    }

}
