package cpclub.weeksix;

import daily.leetcode.TreeNode;

public class MaxProductBinaryTreeSplit {

    static long maxPro;

    public static int maxProduct(TreeNode root) {
        maxPro = Integer.MIN_VALUE;
        int totalSum = sum(root);

        int mod = (int) (1e9 + 7);
        solve(root, totalSum);
        return (int) (maxPro % mod);
    }

    private static long solve(TreeNode root, int totalSum) {
        if (root == null) return 0;
        long left = solve(root.left, totalSum);
        long right = solve(root.right, totalSum);

        long leftCut = totalSum - left;
        if ((left * leftCut) > maxPro) maxPro = (left * leftCut);

        long rightCut = totalSum - right;
        if ((right * rightCut) > maxPro) maxPro = (right * rightCut);

        return root.val + left + right;
    }

    private static int sum(TreeNode root) {
        if (root == null) return 0;
        return sum(root.right) + sum(root.left) + root.val;
    }
}
