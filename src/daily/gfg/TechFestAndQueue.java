package daily.gfg;

import java.util.HashMap;

public class TechFestAndQueue {

    public static long sumOfPowers(long a, long b) {
        long count = 0;
        while (a <= b) count += primeFactors((int) a++);
        return count;
    }

    public static long primeFactors(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n % 2 == 0) {
            map.put(2, map.getOrDefault(2, 0) + 1);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        long count = 0;
        if (n > 2) map.put(n, map.getOrDefault(n, 0) + 1);

        for (Integer value : map.values()) count += value;
        return count;
    }
}
