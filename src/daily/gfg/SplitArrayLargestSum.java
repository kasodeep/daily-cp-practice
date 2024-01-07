package daily.gfg;

public class SplitArrayLargestSum {

    static int splitArray(int[] arr, int N, int K) {
        int totalSum = 0, max = Integer.MIN_VALUE;
        for (int a : arr) {
            totalSum += a;
            max = Math.max(max, a);
        }

        int lo = max, hi = totalSum, ans = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValid(arr, mid, K)) {
                ans = Math.min(ans, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] arr, int requiredSum, int k) {
        int sum = 0, count = 1;
        for (int a : arr) {
            if (sum + a <= requiredSum) {
                sum += a;
            } else {
                sum = a;
                count++;
            }
        }
        return count <= k;
    }
}
