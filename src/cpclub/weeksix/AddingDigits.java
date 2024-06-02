package cpclub.weeksix;

import java.util.Scanner;

/**
 * The basic trick is zero doesn't change the divisibility.
 */
public class AddingDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int i;
        for (i = 0; i <= 9; i++) if ((a * 10 + i) % b == 0) break;
        if (i == 10) {
            System.out.println(-1);
            return;
        }

        StringBuilder ans = new StringBuilder(String.valueOf(a * 10 + i));
        while (n-- > 1) ans.append(0);
        System.out.println(ans);
    }
}
