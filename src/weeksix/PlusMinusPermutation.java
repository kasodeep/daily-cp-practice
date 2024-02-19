package weeksix;

import java.util.Scanner;

public class PlusMinusPermutation {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long rangeSum(long l, long r) {
        if (l > r) return 0;
        return (r - l + 1) * (l + r) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long l = lcm(x, y);
            long plus = n / x - n / l;
            long minus = n / y - n / l;

            long result = rangeSum(n - plus + 1, n) - rangeSum(1, minus);
            System.out.println(result);
        }
        sc.close();
    }
}
