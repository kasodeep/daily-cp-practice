package weekthree;

import java.util.Arrays;
import java.util.Scanner;

public class VanyaAndLanterns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        Arrays.sort(a);

        int rez = 2 * Math.max(a[0], l - a[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            rez = Math.max(rez, a[i + 1] - a[i]);
        }

        System.out.printf("%.10f\n", rez / 2.0);
    }
}
