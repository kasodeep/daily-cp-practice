package weekthree;

import java.util.Scanner;

public class PointsOnPlane {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            long n = sc.nextLong();
            long l = -1;
            long r = (long) 1e9;

            while (r - l > 1) {
                long mid = (l + r) / 2;
                if (mid * mid >= n) r = mid;
                else l = mid;
            }
            System.out.println(r - 1);
        }
    }
}
