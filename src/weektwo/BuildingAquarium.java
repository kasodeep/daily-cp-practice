package weektwo;

import java.util.Scanner;

public class BuildingAquarium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();

            long[] corals = new long[n];
            for (int i = 0; i < n; i++) corals[i] = sc.nextLong();

            long min = 1, max = 2000000007;
            long ans = 0;
            while (min <= max) {
                long mid = min + (max - min) / 2;
                if (isValid(corals, mid, x)) {
                    min = mid + 1;
                    ans = Math.max(ans, mid);
                } else {
                    max = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean isValid(long[] corals, long height, long amount) {
        long sum = 0;
        for (long coral : corals) {
            if (height > coral) sum += height - coral;
        }
        return sum <= amount;
    }
}
