package weeksix;

import java.util.Scanner;

public class AAndB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int tc = 0; tc < t; ++tc) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int d = Math.abs(a - b);
            if (d == 0) {
                System.out.println("0");
                continue;
            }

            int res = 1;
            while (!ok(res, d)) ++res;
            System.out.println(res);
        }
    }

    static boolean ok(int res, int d) {
        long sum = (long) res * (res + 1) / 2;
        if (sum < d) return false;
        return sum % 2 == d % 2;
    }
}
