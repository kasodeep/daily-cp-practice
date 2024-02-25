package daily.gfg;

public class ReachGivenScore {

    public static long count(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 0;

        for (int i = 3; i <= n; i++) dp[i] += dp[i - 3];
        for (int i = 5; i <= n; i++) dp[i] += dp[i - 5];
        for (int i = 10; i <= n; i++) dp[i] += dp[i - 10];
        return dp[n];
    }
}
