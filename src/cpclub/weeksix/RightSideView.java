package cpclub.weeksix;

import daily.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void preorder(TreeNode root, List<Integer> ans, int level) {
        if (root == null) return;
        ans.set(level - 1, root.val);
        preorder(root.left, ans, level + 1);
        preorder(root.right, ans, level + 1);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        int level = height(root) + 1;

        for (int i = 0; i < level; i++) ans.add(100);
        preorder(root, ans, 1);
        return ans;
    }
}

