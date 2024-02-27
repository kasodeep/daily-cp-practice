package weeksix;

import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {

    public static ArrayList<String> findSum(int[][] arr, int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(arr, n, 0, 0, ans, "");
        Collections.sort(ans);
        return ans;
    }

    public static void helper(int[][] arr, int n, int i, int j, ArrayList<String> ans, String path) {
        if (i < 0 || j < 0 || i >= n || j >= n || arr[i][j] == 0) return;
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
        }

        arr[i][j] = 0;
        helper(arr, n, i + 1, j, ans, path + "D");
        helper(arr, n, i, j + 1, ans, path + "R");
        helper(arr, n, i, j - 1, ans, path + "L");
        helper(arr, n, i - 1, j, ans, path + "U");
        arr[i][j] = 1;
    }
}
