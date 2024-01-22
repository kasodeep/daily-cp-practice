package daily.leetcode;

public class SetMisMatch {

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] v = new int[n + 1];

        int missing = 0, duplicate = 0;
        for (int num : nums) v[num]++;

        for (int i = 1; i < v.length; i++) {
            if (v[i] == 2) duplicate = i;
            if (v[i] == 0) missing = i;
        }

        return new int[]{duplicate, missing};
    }
}
