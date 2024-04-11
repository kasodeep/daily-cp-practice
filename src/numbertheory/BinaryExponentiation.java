package numbertheory;

/**
 * The class is used to find the pow of a and b in O(logn) time.
 */
public class BinaryExponentiation {

    // Recursive.
    public static long binaryPow(long a, long b) {
        if (b == 0) return 1;
        long res = binaryPow(a, b / 2);

        if (b % 2 == 0) {
            return res * res;
        } else {
            return res * res * a;
        }
    }

    // Iterative
    public static long pow(long a, int b) {
        if (b < 0) {
            b = -b;
            a = 1 / a;
        }

        long res = 1;
        while (b != 0) {
            if ((b & 1) != 0) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    // Mod
    public static long pow(long a, long b, long m) {
        a %= m;

        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
}
