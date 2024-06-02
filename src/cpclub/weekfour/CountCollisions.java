package cpclub.weekfour;

public class CountCollisions {

    public static int monkeyMove(int n) {
        int mod = 1000000007;
        int ans = (int) power(2, n, mod) - 2;
        return ans + ((ans < 0) ? mod : 0);
    }

    private static long power(long x, int y, int mod) {
        long res = 1;
        x %= mod;
        if (x == 0) return 0;

        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % mod;
            y /= 2;
            x = (x * x) % mod;
        }
        return res;
    }
}
