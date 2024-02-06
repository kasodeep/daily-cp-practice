package weekfive;

import daily.leetcode.TreeNode;

public class HouseRobber3 {

    public static int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }

    private static int[] travel(TreeNode root) {
        if (root == null) return new int[2];

        int[] leftChoice = travel(root.left);
        int[] rightChoice = travel(root.right);

        int[] options = new int[2];

        options[0] = root.val + (leftChoice[1] + rightChoice[1]);
        options[1] = Math.max(leftChoice[0], leftChoice[1]) + Math.max(rightChoice[0], rightChoice[1]);

        return options;
    }
}
