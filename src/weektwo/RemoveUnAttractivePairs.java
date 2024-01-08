package weektwo;

import java.util.Scanner;

/**
 * Frequency of characters matters.
 */
public class RemoveUnAttractivePairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] cnt = new int[26];
            String input = sc.next();

            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                cnt[(int) c - 'a'] += 1;
            }

            int mx = 0;
            for (int j = 0; j < 26; j++) mx = Math.max(mx, cnt[j]);
            System.out.println(Math.max(n % 2, 2 * mx - n));
        }
    }
}
