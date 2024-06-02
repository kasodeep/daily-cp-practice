package cpclub.weekthree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack to the top.
 * */
public class Pattern132 {

    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        int max2 = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max2) return true;

            while (!stack.isEmpty() && stack.peek() < nums[i])
                max2 = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
