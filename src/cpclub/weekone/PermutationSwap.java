package cpclub.weekone;

import java.util.Scanner;

/**
 * Division of every number GCD comes to play.
 */
public class PermutationSwap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int ans = Math.abs(arr[0] - 1);
            for (int i = 1; i < n; i++) ans = gcd(Math.abs(arr[i] - i - 1), ans);
            System.out.println(ans);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
