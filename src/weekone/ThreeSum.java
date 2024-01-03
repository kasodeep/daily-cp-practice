package weekone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Using Two Pointer Approach. Keeping I fixed moving the other two.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // For Handling Duplicates.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two Pointers.
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) k--;
                else if (sum < 0) j++;
                else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ls.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {

    }
}
