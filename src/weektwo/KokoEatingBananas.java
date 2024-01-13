package weektwo;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int num : piles) max = Math.max(num, max);

        int st = 1, end = max;
        int ans = Integer.MAX_VALUE;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isProper(piles, h, mid)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isProper(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }
}
