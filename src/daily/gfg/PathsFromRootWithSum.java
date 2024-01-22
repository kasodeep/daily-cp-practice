package daily.gfg;

import java.util.ArrayList;

public class PathsFromRootWithSum {

    public static void solve(TreeNode root, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list) {
        if (root == null) return;
        if (sum == root.data) {
            list.add(root.data);
            ans.add(list);
        } else {
            list.add(root.data);
        }

        solve(root.left, sum - root.data, ans, new ArrayList<>(list));
        solve(root.right, sum - root.data, ans, new ArrayList<>(list));
    }

    public static ArrayList<ArrayList<Integer>> printPaths(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(root, sum, ans, temp);
        return ans;
    }
}
