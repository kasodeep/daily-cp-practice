package daily.leetcode;

public class MaxDifferenceNodeAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int min, int max) {
        if (root == null) return max - min;

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int left = dfs(root.left, min, max);
        int right = dfs(root.right, min, max);
        return Math.max(left, right);
    }
}
