package daily.gfg;

public class CountPairsMatrix {

    static int countPairs(int[][] mat1, int[][] mat2, int n, int x) {
        int res = 0;
        for (int[] row : mat1) {
            for (int num : row) res += search(mat2, x - num);
        }
        return res;
    }

    public static int search(int[][] mat, int target) {
        int n = mat.length;
        int r = 0, c = n - 1;
        while (r < n && c >= 0) {
            if (mat[r][c] == target) return 1;
            if (mat[r][c] < target) r++;
            else c--;
        }
        return 0;
    }
}
