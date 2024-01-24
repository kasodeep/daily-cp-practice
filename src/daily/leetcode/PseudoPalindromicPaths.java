package daily.leetcode;

/**
 * Next Time, we need to check for this trick!
 * */
public class PseudoPalindromicPaths {

    static int count = 0;

    public static void preorder(TreeNode node, int path) {
        if (node != null) {
            // Compute occurrences of each digit in the corresponding register.
            path = path ^ (1 << node.val);

            if (node.left == null && node.right == null) {
                if ((path & (path - 1)) == 0) ++count;
            }

            preorder(node.left, path);
            preorder(node.right, path);
        }
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        preorder(root, 0);
        return count;
    }
}
