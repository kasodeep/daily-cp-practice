package cpclub.weektwo;

import java.util.ArrayList;
import java.util.Scanner;

public class FlowerCityFence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = scanner.nextInt();

            if (a[1] != n) {
                System.out.println("NO");
                continue;
            }

            ArrayList<Integer> b = new ArrayList<>();
            for (int i = n; i >= 1; i--) {
                while (b.size() < a[i]) b.add(i);
            }

            boolean meow = true;
            for (int i = 1; i <= n; i++) {
                if (a[i] != b.get(i - 1)) {
                    System.out.println("NO");
                    meow = false;
                    break;
                }
            }

            if (meow) System.out.println("YES");
        }
    }
}
