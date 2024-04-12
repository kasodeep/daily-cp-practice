package numbertheory;

public class PrimeTest {

    public static boolean isPrime(int x) {
        for (int d = 2; d * d <= x; d++) {
            if (x % d == 0) return false;
        }
        return x >= 2;
    }

    public static long largestPrimeFactor(int N) {
        long max = 0;
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                max = Math.max(max, i);
                N = N / i;
            }
        }

        if (N > 1) max = Math.max(max, N);
        return max;
    }
}
