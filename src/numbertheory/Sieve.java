package numbertheory;

import java.util.Arrays;

public class Sieve {

    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static int count(boolean[] sieve) {
        int count = 0;
        for (boolean b : sieve) if (b) count++;
        return count;
    }
}
