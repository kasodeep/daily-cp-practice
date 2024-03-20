package weekseven;

import java.util.Scanner;

public class AttackMonsters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];
            int[] x = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            for (int i = 0; i < n; i++) x[i] = scanner.nextInt();

            long[] s = new long[n + 1];
            for (int i = 0; i < n; ++i) s[Math.abs(x[i])] += a[i];

            boolean ok = true;
            long lft = 0;
            for (int i = 1; i <= n; ++i) {
                lft += k - s[i];
                ok &= (lft >= 0);
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}