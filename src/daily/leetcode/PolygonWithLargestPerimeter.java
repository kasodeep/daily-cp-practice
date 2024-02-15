package daily.leetcode;

import java.util.Arrays;

public class PolygonWithLargestPerimeter {

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) sum += num;

        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            if (sum - nums[i] > nums[i]) return sum;
            sum -= nums[i];
        }
        return -1;
    }
}
