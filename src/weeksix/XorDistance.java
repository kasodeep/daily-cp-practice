package weeksix;

import java.util.Scanner;

/**
 * If bits in a and b are same, we can place 0 at that position in x.
 * If they are different it is better to put 1 in place of x.
 * (1L << i), important when working with bit manipulation.
 */
public class XorDistance {

    static final int maxB = 60;

    static boolean getBit(long a, int i) {
        return (a & (1L << i)) != 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long r = sc.nextLong();

            long x = 0;
            boolean firstBit = true;
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }

            for (int i = maxB - 1; i >= 0; --i) {
                boolean bitA = getBit(a, i);
                boolean bitB = getBit(b, i);
                if (bitA != bitB) {
                    if (firstBit) {
                        firstBit = false;
                    } else {
                        if (!bitA && x + (1L << i) <= r) {
                            x += (1L << i);
                            a ^= (1L << i);
                            b ^= (1L << i);
                        }
                    }
                }
            }
            System.out.println(b - a);
        }
    }
}
