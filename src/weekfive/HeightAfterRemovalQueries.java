package weekfive;

import daily.leetcode.TreeNode;

public class HeightAfterRemovalQueries {

    static final int[] htWithout = new int[100_001];
    static int maxHeight = 0;

    public static int[] treeQueries(TreeNode root, int[] queries) {
        maxHeight = 0;
        traverseLeftToRight(root, 0);
        maxHeight = 0;
        traverseRightToLeft(root, 0);

        int[] result = new int[queries.length];
        for (int i = queries.length - 1; i >= 0; i--) result[i] = htWithout[queries[i]];
        return result;
    }


    private static void traverseLeftToRight(TreeNode node, int height) {
        htWithout[node.val] = maxHeight;
        if (height > maxHeight) maxHeight = height;

        if (node.left != null) traverseLeftToRight(node.left, height + 1);
        if (node.right != null) traverseLeftToRight(node.right, height + 1);
    }


    private static void traverseRightToLeft(TreeNode node, int height) {
        if (maxHeight > htWithout[node.val]) htWithout[node.val] = maxHeight;
        if (height > maxHeight) maxHeight = height;

        if (node.right != null) traverseRightToLeft(node.right, height + 1);
        if (node.left != null) traverseRightToLeft(node.left, height + 1);
    }
}
