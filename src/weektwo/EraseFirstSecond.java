package weektwo;

import java.util.Scanner;

public class EraseFirstSecond {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            long[] ans = new long[n];
            int[] nxt = new int[26];
            for (int i = 0; i < 26; i++) {
                nxt[i] = n;
            }

            ans[n - 1] = 1;
            nxt[s.charAt(n - 1) - 'a'] = n - 1;

            for (int i = n - 2; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                ans[i] = ans[i + 1] + (nxt[idx] - i);
                nxt[idx] = i;
            }

            System.out.println(ans[0]);
        }
    }
}
