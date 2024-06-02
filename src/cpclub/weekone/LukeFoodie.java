package cpclub.weekone;

import java.util.Scanner;

/**
 * Using the Greedy Approach for max range of v.
 */
public class LukeFoodie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            long max = arr[0];
            long min = arr[0];

            long count = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min = arr[i];

                if ((max - min) > 2 * x) {
                    max = arr[i];
                    min = arr[i];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
