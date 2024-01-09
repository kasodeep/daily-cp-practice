package weektwo;

import java.util.Scanner;

public class PoisonedDagger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long h = sc.nextLong();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            long st = 1, end = h, ans = Long.MAX_VALUE;
            while (st <= end) {
                long mid = st + (end - st) / 2;
                if (isKiller(arr, mid, h)) {
                    ans = Math.min(ans, mid);
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean isKiller(long[] arr, long mid, long h) {
        long sum = 0;
        for (int i = 0; i < arr.length - 1; i++) sum += Math.min(arr[i + 1] - arr[i], mid);

        sum += mid;
        return sum >= h;
    }
}
