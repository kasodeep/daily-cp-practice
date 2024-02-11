package weekfive;

import daily.leetcode.TreeNode;

import java.util.LinkedList;

public class MaximumWidth {

    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        if (root == null) return 0;
        q.addLast(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(max, (q.getLast().level - q.getFirst().level + 1));

            for (int i = 0; i < size; i++) {
                Pair element = q.removeFirst();
                if (element.root.left != null)
                    q.addLast(new Pair(element.root.left, 2 * element.level));

                if (element.root.right != null)
                    q.addLast(new Pair(element.root.right, 2 * element.level + 1));
            }
        }
        return max;
    }

    static class Pair {
        int level;
        TreeNode root;

        public Pair(TreeNode root, int level) {
            this.level = level;
            this.root = root;
        }
    }
}
