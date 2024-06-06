package daily.gfg;

public class MaxConfiguration {

    long maxSum(int[] a, int n) {
        long sum = 0;
        long arraySum = 0;

        for (int i = 0; i < n; i++) {
            sum += (long) i * a[i];
            arraySum += a[i];
        }

        long maxSum = sum;
        for (int i = 1; i < n; i++) {
            sum = sum + arraySum - (long) n * a[n - i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
