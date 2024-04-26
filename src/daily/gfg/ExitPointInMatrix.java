package daily.gfg;

public class ExitPointInMatrix {

    public static int[] FindExitPoint(int n, int m, int[][] matrix) {
        int dir = 1;
        int i = 0, j = 0;
        int[] ans = new int[2];

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;
                dir = (dir % 4) + 1;
            }

            if (dir == 1) j++;
            else if (dir == 2) i++;
            else if (dir == 3) j--;
            else i--;
        }

        if (dir == 1) j--;
        else if (dir == 2) i--;
        else if (dir == 3) j++;
        else i++;

        ans[0] = i;
        ans[1] = j;
        return ans;
    }
}
