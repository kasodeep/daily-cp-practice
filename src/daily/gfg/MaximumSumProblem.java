package daily.gfg;

public class MaximumSumProblem {

    public static int maxSum(int n) {
        if (n == 0) return 0;
        int x = maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4);
        return Math.max(n, x);
    }
}
