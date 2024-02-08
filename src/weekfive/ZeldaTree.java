package weekfive;

import java.util.Scanner;

public class ZeldaTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] frequency = new int[n + 1];

            for (int i = 0; i < n - 1; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();

                frequency[p]++;
                frequency[c]++;
            }

            int count = 0;
            for (int i = 1; i <= n; i++) if (frequency[i] == 1) count++;
            System.out.println((count + 1) / 2);
        }
    }
}
