package daily.gfg;

public class ShortestSafeRoute {

    static int ans;

    public static int findShortestPath(int[][] mat) {
        int r = mat.length, c = mat[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    if (i + 1 < r) mat[i + 1][j] = -1;
                    if (j + 1 < c) mat[i][j + 1] = -1;
                    if (i - 1 >= 0) mat[i - 1][j] = -1;
                    if (j - 1 >= 0) mat[i][j - 1] = -1;
                }
            }
        }

        ans = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            if (mat[i][0] != 0) dfs(i, 0, r, c, mat, 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void dfs(int i, int j, int r, int c, int[][] mat, int len) {
        if (i < 0 || j < 0 || i >= r || j >= c || mat[i][j] == 0 || mat[i][j] == -1) return;

        if (j == c - 1) {
            ans = Math.min(ans, len);
            return;
        }

        mat[i][j] = 0;
        dfs(i + 1, j, r, c, mat, len + 1);
        dfs(i, j + 1, r, c, mat, len + 1);
        dfs(i - 1, j, r, c, mat, len + 1);
        dfs(i, j - 1, r, c, mat, len + 1);
        mat[i][j] = 1;
    }
}
