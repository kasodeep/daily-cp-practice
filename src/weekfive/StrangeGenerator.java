package weekfive;

import java.util.Scanner;

public class StrangeGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        outer: while (q-- > 0) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) p[i] = scanner.nextInt();

            int[] pos = new int[n];
            for (int i = 0; i < n; i++)
                pos[--p[i]] = i;

            boolean[] was = new boolean[n];
            for (int i = 0; i < n; ++i) {
                if (was[i]) continue;

                int me = pos[i];
                while (me < n) {
                    was[me] = true;
                    if (me + 1 == n) break;
                    if (was[me + 1]) break;

                    if (p[me + 1] == p[me] + 1) {
                        ++me;
                        continue;
                    }

                    System.out.println("No");
                    continue outer;
                }
            }
            System.out.println("Yes");
        }

    }
}
