package weekfive;

import daily.leetcode.TreeNode;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left, right;
        if (root == null || root == p || root == q) return root;

        right = lowestCommonAncestor(root.right, p, q);
        left = lowestCommonAncestor(root.left, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
