package leetcode;

import java.util.Arrays;

public class MaxOperations {

    public static int maxOperations(int[] nums) {
        int n = nums.length;
        if (n == 2) return 1;

        int[][] dp1 = new int[n + 1][n + 1];
        int[][] dp2 = new int[n + 1][n + 1];
        int[][] dp3 = new int[n + 1][n + 1];
        for (int[] temp : dp1) Arrays.fill(temp, -1);
        for (int[] temp : dp2) Arrays.fill(temp, -1);
        for (int[] temp : dp3) Arrays.fill(temp, -1);

        int first = nums[0] + nums[1];
        int last = nums[n - 2] + nums[n - 1];
        int both = nums[0] + nums[n - 1];

        int one = helper(nums, 2, n - 1, first, dp1);
        int two = helper(nums, 1, n - 2, both, dp2);
        int three = helper(nums, 0, n - 3, last, dp3);
        return Math.max(one, Math.max(two, three)) + 1;
    }

    public static int helper(int[] nums, int i, int j, int sum, int[][] dp) {
        if (j <= i) return 0;

        if (dp[i][j] != -1)
            return 0;
        if (j - i == 1) {
            if (sum == nums[i] + nums[j]) return 1;
            else return 0;
        }

        int first = nums[i] + nums[i + 1];
        int last = nums[j] + nums[j - 1];
        int both = nums[i] + nums[j];
        int one = 0, two = 0, three = 0;
        if (first == sum) {
            one = helper(nums, i + 2, j, sum, dp) + 1;
        }
        if (last == sum) {
            two = helper(nums, i, j - 2, sum, dp) + 1;
        }
        if (both == sum) {
            three = helper(nums, i + 1, j - 1, sum, dp) + 1;
        }
        return dp[i][j] = Math.max(one, Math.max(two, three));
    }
}
