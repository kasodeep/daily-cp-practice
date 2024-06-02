package cpclub.weektwo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectlyBalancedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        while (tc-- > 0) {
            String s = scanner.next();
            int n = s.length();
            Set<Character> set = new HashSet<>();

            boolean ok = true;
            int k;

            for (k = 0; k < n; k++) {
                if (!set.contains(s.charAt(k))) set.add(s.charAt(k));
                else break;
            }

            for (int i = k; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - k)) {
                    ok = false;
                    break;
                }
            }

            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
