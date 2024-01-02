package daily.gfg;

/**
 * Decided to use Kadane's Algorithm.
 * Got tricked in Sliding Window Part.
 */
public class LargestSubArraySumSizeK {

    public static long maxSumWithK(long[] a, long n, long k) {
        // maxSum[i] is going to store maximum sum till index i.
        long[] maxSum = new long[(int) n];
        maxSum[0] = a[0];

        long currMax = a[0];
        for (int i = 1; i < n; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSum[i] = currMax;
        }

        long sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];

        // Using the concept of sliding window.
        long result = sum;
        for (int i = (int) k; i < n; i++) {
            // Compute sum of k elements ending with a[i]
            sum = sum + a[i] - a[i - (int) k];

            // Update result if required.
            result = Math.max(result, sum);

            // Include maximum sum till [i-k] also if it increases overall max.
            result = Math.max(result, sum + maxSum[i - (int) k]);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
