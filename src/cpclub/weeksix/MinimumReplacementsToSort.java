package cpclub.weeksix;

public class MinimumReplacementsToSort {

    public static long minimumReplacement(int[] nums) {
        int curMax = nums[nums.length - 1];
        long count = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if (num <= curMax) {
                curMax = num;
            } else {
                if (num % curMax == 0) {
                    count += (num / curMax - 1);
                } else {
                    int divide = num / curMax;
                    count += divide;
                    curMax = num / (divide + 1);
                }
            }
        }
        return count;
    }
}
