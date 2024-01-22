package weekthree;

import java.util.Arrays;
import java.util.Scanner;

public class WoodenToyFestival {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

            Arrays.sort(a);
            int l = -1, r = 1000000000;

            while (r - l > 1) {
                int m = (l + r) / 2;

                int i = 0;
                while (i + 1 < a.length && a[i + 1] - a[0] <= 2 * m) {
                    i++;
                }

                int j = n - 1;
                while (j - 1 >= 0 && a[a.length - 1] - a[j - 1] <= 2 * m) {
                    j--;
                }

                i++;
                j--;
                if (i > j || a[j] - a[i] <= 2 * m) {
                    r = m;
                } else {
                    l = m;
                }
            }
            System.out.println(r);
        }
        scanner.close();

    }
}
