package cpclub.weekone;

import java.util.Scanner;

/**
 * Only 4 numbers to divide, easy one.
 */
public class Raspberries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int count = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (temp % 2 == 0) count++;

                if (temp % k == 0) {
                    min = 0;
                    continue;
                }

                if (temp <= k) min = Math.min(min, k - temp);
                else min = Math.min(min, k - (temp % k));
            }

            if (k == 4)
                System.out.println(Math.min(min, Math.max(0, 2 - count)));
            else
                System.out.println(min);
        }
    }
}
