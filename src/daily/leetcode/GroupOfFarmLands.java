package daily.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GroupOfFarmLands {

    int h = 0;
    int k = 0;

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    dfs(land, i, j, m, n);
                    ans.add(new int[]{i, j, h, k});
                    h = 0;
                    k = 0;
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public void dfs(int[][] land, int u, int v, int m, int n) {
        if (u < 0 || v < 0 || u >= m || v >= n || land[u][v] == 0)
            return;

        land[u][v] = 0;
        h = Math.max(h, u);
        k = Math.max(k, v);

        dfs(land, u + 1, v, m, n);
        dfs(land, u, v + 1, m, n);
    }
}
