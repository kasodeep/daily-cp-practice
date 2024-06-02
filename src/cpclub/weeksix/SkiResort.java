package cpclub.weeksix;

import java.util.Scanner;

public class SkiResort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long q = sc.nextLong();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            long count = 0;
            int i = 0;
            while (i < n) {
                long temp = 0;
                while (i < n && arr[i] <= q) {
                    i++;
                    temp++;
                }
                count += temp < k ? 0 : (temp - k + 1) * (temp - k + 2) / 2;
                i++;
            }
            System.out.println(count);
        }
    }
}
