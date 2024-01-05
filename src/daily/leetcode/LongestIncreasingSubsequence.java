package daily.leetcode;

import java.util.Arrays;

/**
 * Initial Approach was to use sorting. It passed 30 TC's.
 * Then decided to use DP.
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int len = 1;
        temp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (temp[len - 1] < nums[i]) {
                temp[len++] = nums[i];
            } else {
                int ind = Arrays.binarySearch(temp, 0, len, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                temp[ind] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
