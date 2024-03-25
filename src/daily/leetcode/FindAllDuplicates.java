package daily.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, n = nums.length;

        while (i < n) {
            if (nums[i] == i + 1) {
                nums[i] = -1;
                i++;
                continue;
            }

            if (nums[i] == -1) {
                i++;
            } else {
                int temp = nums[nums[i] - 1];
                if (temp == -1) {
                    i++;
                } else {
                    nums[nums[i] - 1] = -1;
                    nums[i] = temp;
                }
            }
        }

        for (int num : nums) if (num != -1) ans.add(num);
        return ans;
    }
}
