package weeksix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimizeDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            ArrayList<Integer> pos = new ArrayList<>();
            ArrayList<Integer> neg = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (temp < 0) neg.add(-temp);
                else pos.add(temp);
            }

            Collections.sort(pos);
            Collections.sort(neg);

            long sum = 0;
            for (int i = pos.size() - 1; i >= 0; ) {
                int temp = k;
                int tempMax = -1;
                while (i >= 0 && temp-- > 0) {
                    tempMax = Math.max(pos.get(i), tempMax);
                    i--;
                }
                sum += tempMax;
            }
            for (int i = neg.size() - 1; i >= 0; ) {
                int temp = k;
                int tempMax = -1;
                while (i >= 0 && temp-- > 0) {
                    tempMax = Math.max(neg.get(i), tempMax);
                    i--;
                }
                sum += tempMax;
            }

            int posMax = pos.size() > 0 ? pos.get(pos.size() - 1) : 0;
            int negMax = neg.size() > 0 ? neg.get(neg.size() - 1) : 0;
            System.out.println(2 * sum - Math.max(posMax, negMax));
        }
    }
}
