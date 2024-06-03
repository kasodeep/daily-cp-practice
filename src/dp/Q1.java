package dp;

import java.util.Arrays;

/**
 * We are given N items with their weights Wi and value Vi.
 * We can take at most K items and at most W weight.
 */
public class Q1 {

    public static void main(String[] args) {
        int[] values = {3, 5, 4};
        int[] weights = {1, 5, 2};
        int K = 2;
        int W = 5;

        // solve.
        int n = values.length;
        int[][][] dp = new int[n + 1][W + 1][K + 1];
        for (int[][] outer : dp) {
            for (int[] inner : outer) Arrays.fill(inner, -1);
        }

        System.out.println(solve(0, W, K, n, dp, values, weights));
    }

    public static int solve(int i, int W, int K, int n, int[][][] dp, int[] val, int[] wt) {
        if (i == n) return 0;
        if (K == 0) return 0;
        if (dp[i][W][K] != -1) return dp[i][W][K];

        if (wt[i] <= W) {
            return dp[i][W][K] = Math.max(solve(i + 1, W - wt[i], K - 1, n, dp, val, wt) + val[i],
                    solve(i + 1, W, K, n, dp, val, wt));
        }
        return dp[i][W][K] = solve(i + 1, W, K, n, dp, val, wt);
    }
}
