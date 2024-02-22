package daily.gfg;

import java.util.Arrays;

public class DistinctOccurences {

    static int[][] dp;
    static int mod = 1000000007;

    static int subsequenceCount(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int[] temp : dp) Arrays.fill(temp, -1);
        return helper(0, 0, s.length(), t.length(), s, t);
    }

    static int helper(int i, int j, int n, int m, String s, String t) {
        if (j == m) return 1;
        if (i == n) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int count = 0;
        if (s.charAt(i) == t.charAt(j)) count += helper(i + 1, j + 1, n, m, s, t);
        count %= mod;

        count += helper(i + 1, j, n, m, s, t);
        dp[i][j] = count % mod;
        return dp[i][j];
    }
}
