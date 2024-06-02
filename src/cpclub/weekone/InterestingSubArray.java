package cpclub.weekone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The trick is when there is negative and positive numbers.
 * Trying to use long when A[i] <= 10^9.
 */
public class InterestingSubArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            Arrays.sort(arr);
            long maxPositive = arr[n - 1] * arr[n - 1];
            long minPositive = arr[0] * arr[0];

            long min = Math.min(minPositive, Math.min((arr[0] * arr[n - 1]), maxPositive));
            long max = Math.max(minPositive, maxPositive);
            System.out.println(min + " " + max);
        }
    }
}
