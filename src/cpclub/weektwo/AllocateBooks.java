package cpclub.weektwo;

import java.util.ArrayList;

/**
 * The min sum will be if I separate the largest value.
 * The largest will be if all of them together.
 * Crazy Binary Search Question.
 */
public class AllocateBooks {

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        long sum = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            max = Math.max(max, arr.get(i));
        }

        if (m > n) return -1;
        long start = max, end = sum, ans = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValid(arr, mid, m)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) ans;
    }

    public static boolean isValid(ArrayList<Integer> arr, long requiredSum, int m) {
        long sum = 0;
        int count = 1;
        for (Integer integer : arr) {
            if (sum + integer <= requiredSum) {
                sum += integer;
            } else {
                sum = integer;
                count++;
            }
        }
        return count <= m;
    }
}
