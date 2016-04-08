package ranker;

import java.math.BigInteger;
import java.util.BitSet;
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

        byte[] a = {1, 2};
        BigInteger bigInteger = new BigInteger(a);
        System.out.println(bigInteger.toString());
        stdin.close();
    }


    private static void factory(int n) {
        BigInteger bigInteger = new BigInteger(String.valueOf(1));
        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInteger);
    }


    public static void compare(BitSet[] bitSets, int n, int t) {
        int max = 0;
        int group = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                BitSet result = (BitSet) bitSets[i].clone();
                result.or(bitSets[j]);
                int sameCount = getBitSet1Count(result, t);
                if (sameCount == max) {
                    group++;
                } else if (sameCount > max) {
                    max = sameCount;
                    group = 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(group);
    }

    public static int getBitSet1Count(BitSet bitset, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (bitset.get(i)) {
                count++;
            }
        }
        return count;
    }
}
