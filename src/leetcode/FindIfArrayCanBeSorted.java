package leetcode;

import java.util.Arrays;

public class FindIfArrayCanBeSorted {

    public boolean canSortArray(int[] nums) {
        int start = 0;

        while (start < nums.length) {
            int end = start;
            int bitCount = Integer.bitCount(nums[start]);
            while (end < nums.length && Integer.bitCount(nums[end]) == bitCount) {
                end++;
            }

            Arrays.sort(nums, start, end);
            start = end;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }
}
