package daily.gfg;

public class SumOfBitDifferences {

    long sumBitDifferences(int[] arr, int n) {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) != 0) count++;
            ans += (long) count * (n - count) * 2;
        }

        return ans;
    }
}
