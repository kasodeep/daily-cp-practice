package leetcode;

import java.util.ArrayDeque;

public class SubArraysWhereBoundaryMax {

    public static long numberOfSubarrays(int[] A) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        long res = 0;

        for (int a : A) {
            while (!stack.isEmpty() && stack.peek()[0] < a)
                stack.pop();

            if (stack.isEmpty() || stack.peek()[0] != a)
                stack.push(new int[]{a, 0});

            res += ++stack.peek()[1];
        }
        return res;
    }
}
