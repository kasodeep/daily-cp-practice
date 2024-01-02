package weekone;

import java.util.Scanner;

/**
 * The sub-array should have alternating parity elements.
 * Solved: The approach was to use Kadane's Algorithm Technique.
 */
public class YarikAndArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            boolean lastEven = arr[0] % 2 == 0;
            int sum = arr[0];
            int result = sum;

            for (int i = 1; i < n; i++) {
                if (lastEven) {
                    if (arr[i] % 2 != 0) {
                        sum = Math.max(arr[i], sum + arr[i]);
                        lastEven = false;
                    } else {
                        sum = arr[i];
                    }
                } else {
                    if (arr[i] % 2 == 0) {
                        sum = Math.max(arr[i], sum + arr[i]);
                        lastEven = true;
                    } else {
                        sum = arr[i];
                    }
                }
                result = Math.max(result, sum);
            }
            System.out.println(result);
        }
    }
}
