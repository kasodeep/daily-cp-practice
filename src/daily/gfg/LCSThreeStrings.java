package daily.gfg;

import java.util.Arrays;

public class LCSThreeStrings {

    static int[][][] memo;

    static int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        memo = new int[n1][n2][n3];
        for (int[][] temp : memo) for (int[] arr : temp) Arrays.fill(arr, -1);

        return solve(0, 0, 0, A, B, C);
    }

    public static int solve(int i, int j, int k, String text1, String text2, String text3) {
        if (i == text1.length()) return 0;
        if (j == text2.length()) return 0;
        if (k == text3.length()) return 0;

        if (memo[i][j][k] != -1) return memo[i][j][k];

        if (text1.charAt(i) == text2.charAt(j) && text1.charAt(i) == text3.charAt(k)) {
            memo[i][j][k] = 1 + solve(i + 1, j + 1, k + 1, text1, text2, text3);
            return memo[i][j][k];
        }

        memo[i][j][k] = Math.max(solve(i, j + 1, k, text1, text2, text3),
                solve(i + 1, j, k, text1, text2, text3));
        memo[i][j][k] = Math.max(memo[i][j][k], Math.max(solve(i, j, k + 1, text1, text2, text3),
                solve(i + 1, j + 1, k, text1, text2, text3)));
        memo[i][j][k] = Math.max(memo[i][j][k], Math.max(solve(i, j + 1, k + 1, text1, text2, text3),
                solve(i + 1, j, k + 1, text1, text2, text3)));

        return memo[i][j][k];
    }
}
