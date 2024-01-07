package weekone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int l = i + 1; l < nums.length - 1; l++) {
                if (l > i + 1 && nums[l] == nums[l - 1]) continue;

                // Two Pointers.
                int j = l + 1;
                int k = nums.length - 1;
                while (j < k) {
                    // Adding them directly, it adds as int.
                    long sum = nums[i];
                    sum += nums[l];
                    sum += nums[j];
                    sum += nums[k];
                    if (sum > target) k--;
                    else if (sum < target) j++;
                    else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[l], nums[j], nums[k]);
                        ls.add(temp);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    }
                }
            }
        }
        return ls;
    }
}
