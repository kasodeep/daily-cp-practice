package daily.leetcode;

public class CherryPickUp2 {

    public static int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];
        return dfs(grid, n, m, 0, 0, m - 1, dp);
    }

    public static int dfs(int[][] grid, int n, int m, int row, int col1, int col2, Integer[][][] dp) {
        // Base case.
        if (row < 0 || row >= n || col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) return 0;
        if (dp[row][col1][col2] != null) return dp[row][col1][col2];

        int maxCherries = 0;
        for (int i = -1; i <= 1; i++) {
            int newCol1 = col1 + i;
            for (int j = -1; j <= 1; j++) {
                int newCol2 = col2 + j;
                maxCherries = Math.max(maxCherries, dfs(grid, n, m, row + 1, newCol1, newCol2, dp));
            }
        }

        int currCherry;
        if (col1 == col2) currCherry = grid[row][col1];
        else currCherry = grid[row][col1] + grid[row][col2];

        return dp[row][col1][col2] = maxCherries + currCherry;
    }
}
