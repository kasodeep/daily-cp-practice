package cpclub.weekfive;

import daily.leetcode.TreeNode;

public class BSTToGreaterTree {

    static int sum = 0;

    public static void helper(TreeNode root) {
        if (root == null) return;

        helper(root.right);
        root.val = root.val + sum;

        sum = root.val;
        helper(root.left);
    }

    public static TreeNode convertBST(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }
}
