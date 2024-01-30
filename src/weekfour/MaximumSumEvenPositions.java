package weekfour;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumSumEvenPositions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            long[][] dp = new long[n + 1][3];
            for (int i = 0; i < n; ++i) {
                dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0] + ((i & 1) == 0 ? a.get(i) : 0));
                if (i + 2 <= n)
                    dp[i + 2][1] = Math.max(dp[i + 2][1], Math.max(dp[i][0], dp[i][1]) + ((i & 1) == 0 ? a.get(i + 1) : a.get(i)));
                dp[i + 1][2] = Math.max(dp[i + 1][2], Math.max(Math.max(dp[i][0], dp[i][1]), dp[i][2]) + ((i & 1) == 0 ? a.get(i) : 0));
            }
            System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
        }
        sc.close();
    }

}
