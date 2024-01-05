package weekone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The idea was to sort the array and use prefix sum.
 * First started iteration from 0, later on realized the use of last element.
 */
public class CollectingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Pair[] pair = new Pair[n];
            long sum = 0;

            for (int i = 0; i < n; i++) {
                pair[i] = new Pair(sc.nextLong(), i);
                sum += pair[i].value;
            }

            Arrays.sort(pair, Comparator.comparingLong(o -> o.value));
            int[] result = new int[n];
            result[pair[n - 1].index] = n - 1;

            for (int i = n - 2; i >= 0; i--) {
                sum -= pair[i + 1].value;
                if (sum >= pair[i + 1].value) {
                    result[pair[i].index] = result[pair[i + 1].index];
                } else {
                    result[pair[i].index] = i;
                }
            }

            for (int i = 0; i < n; i++) System.out.print(result[i] + " ");
            System.out.println();
        }
    }

    static class Pair {
        long value;
        int index;

        public Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
