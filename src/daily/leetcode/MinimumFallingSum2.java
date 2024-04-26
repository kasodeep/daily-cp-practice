package daily.leetcode;

public class MinimumFallingSum2 {

    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        int min = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int col1 = -1;

        for (int i = n - 1; i >= 0; i--) {
            int temp1 = Integer.MAX_VALUE, temp2 = Integer.MAX_VALUE;
            int c1 = -1;
            for (int j = 0; j < n; j++) {
                if (i == n - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (col1 == j)
                        dp[i][j] = grid[i][j] + min2;
                    else
                        dp[i][j] = grid[i][j] + min1;
                }

                if (temp1 == Integer.MAX_VALUE || dp[i][j] < temp1) {
                    temp2 = temp1;
                    temp1 = dp[i][j];
                    c1 = j;
                } else if (temp2 == Integer.MAX_VALUE || dp[i][j] <= temp2) {
                    temp2 = dp[i][j];
                }
            }
            min1 = temp1;
            min2 = temp2;
            col1 = c1;
        }

        for (int j = 0; j < n; j++) {
            min = Math.min(dp[0][j], min);
        }
        return min;
    }
}
