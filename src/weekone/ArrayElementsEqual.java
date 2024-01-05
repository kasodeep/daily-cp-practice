package weekone;

/**
 * Wrote a few test cases and found out it was the difference of all with smallest.
 */
public class ArrayElementsEqual {

    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int num : nums) if (num < min) min = num;
        for (int num : nums) ans += num - min;
        return ans;
    }
}
