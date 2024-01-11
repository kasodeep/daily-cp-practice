package weektwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Greedily looked for the max damage possible and then killed the monsters!
 */
public class Incinerate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long[] health = new long[n];
            long[] power = new long[n];

            for (int i = 0; i < n; i++) health[i] = sc.nextLong();
            for (int i = 0; i < n; i++) power[i] = sc.nextLong();

            Pair[] monsters = new Pair[n];
            for (int i = 0; i < n; i++) monsters[i] = new Pair(health[i], power[i]);
            Arrays.sort(monsters, Comparator.comparingLong(p -> p.power));

            int damage = k;
            int i = 0;
            while (i < n && k > 0) {
                if (monsters[i].health - damage > 0) {
                    k -= monsters[i].power;
                    damage += k;
                } else {
                    i++;
                }
            }

            boolean ans = true;
            for (int j = 0; j < n; j++) {
                if (monsters[j].health - damage > 0) {
                    ans = false;
                    break;
                }
            }

            if (ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static class Pair {
        Long health;
        Long power;

        public Pair(Long health, Long power) {
            this.health = health;
            this.power = power;
        }
    }
}
