package weekone;

import java.util.ArrayList;
import java.util.List;

/**
 * Hard yet Easy.
 * Got the trick of using Merge Sort when left right comparison is required.
 */
public class SmallerNumbersAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        int[] result = new int[n];

        Pair[] newNums = new Pair[n];
        for (int i = 0; i < n; ++i) newNums[i] = new Pair(nums[i], i);
        mergeSortAndCount(newNums, 0, n - 1, result);

        List<Integer> resultList = new ArrayList<>();
        for (int i : result) resultList.add(i);
        return resultList;
    }

    private static void mergeSortAndCount(Pair[] nums, int start, int end, int[] result) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSortAndCount(nums, start, mid, result);
        mergeSortAndCount(nums, mid + 1, end, result);

        int leftPos = start;
        int rightPos = mid + 1;
        ArrayList<Pair> merged = new ArrayList<>();
        int numberOfSmallerElements = 0;

        while (leftPos < mid + 1 && rightPos <= end) {
            if (nums[leftPos].val > nums[rightPos].val) {
                ++numberOfSmallerElements;
                merged.add(nums[rightPos]);
                ++rightPos;
            } else {
                result[nums[leftPos].originalIdx] += numberOfSmallerElements;
                merged.add(nums[leftPos]);
                ++leftPos;
            }
        }

        while (leftPos < mid + 1) {
            result[nums[leftPos].originalIdx] += numberOfSmallerElements;
            merged.add(nums[leftPos]);
            ++leftPos;
        }

        while (rightPos <= end) {
            merged.add(nums[rightPos]);
            ++rightPos;
        }

        int pos = start;
        for (Pair m : merged) {
            nums[pos] = m;
            ++pos;
        }
    }

    private static class Pair {
        int val;
        int originalIdx;

        public Pair(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
        }
    }
}
