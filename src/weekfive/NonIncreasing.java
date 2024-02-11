package weekfive;

import java.util.Scanner;
import java.util.TreeSet;

public class NonIncreasing {

    public static int minSecondsToNonDecreasing(int n, int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int minSeconds = 0;
        TreeSet<Integer> bValues = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            int b_i = maxSoFar;

            bValues.add(b_i);
            Integer lower = bValues.lower(arr[i]);
            if (lower != null) b_i = Math.max(b_i, lower);

            minSeconds = Math.max(minSeconds, (int) Math.ceil(Math.log(b_i - arr[i] + 1) / Math.log(2)));
        }

        return minSeconds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
            System.out.println(minSecondsToNonDecreasing(n, arr));
        }
    }
}
