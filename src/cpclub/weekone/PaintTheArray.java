package cpclub.weekone;

import java.util.*;

/**
 * Not able to solve it. Got stuck at GCD part and didn't figure it out.
 * Division of all numbers by a number might be the case of GCD!
 */
public class PaintTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Long> a = new ArrayList<>();
            for (int i = 0; i < n; i++) a.add(sc.nextLong());

            List<Long> g = new ArrayList<>(a.subList(0, 2));
            for (int i = 0; i < n; i++) {
                g.set(i % 2, gcd(g.get(i % 2), a.get(i)));
            }

            List<Boolean> good = new ArrayList<>(Arrays.asList(true, true));
            for (int i = 0; i < n; i++) {
                good.set(i % 2, good.get(i % 2) && (a.get(i) % g.get((i % 2) ^ 1) > 0));
            }

            long ans = 0;
            for (int i = 0; i < 2; i++) {
                if (good.get(i)) ans = Math.max(ans, g.get(i ^ 1));
            }
            System.out.println(ans);
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

