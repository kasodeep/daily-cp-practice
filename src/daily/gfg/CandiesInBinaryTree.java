package daily.gfg;

public class CandiesInBinaryTree {

    static int count;

    public static int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        count += Math.abs(left) + Math.abs(right);
        return (root.data - 1) + left + right;
    }

    public static int distributeCandy(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        count = 0;
        solve(root);
        return count;
    }
}
