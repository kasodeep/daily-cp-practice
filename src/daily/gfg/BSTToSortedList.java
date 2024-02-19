package daily.gfg;

public class BSTToSortedList {

    static TreeNode p;

    static TreeNode s;

    public static TreeNode flattenBST(TreeNode root) {
        if (root == null) return null;
        flattenBST(root.left);

        if (p != null) {
            p.right = root;
            p.left = null;
        }
        if (p == null) s = root;
        p = root;

        flattenBST(root.right);
        p.right = null;
        p.left = null;
        return s;
    }
}
