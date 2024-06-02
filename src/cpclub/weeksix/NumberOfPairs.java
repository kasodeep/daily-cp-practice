package cpclub.weeksix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberOfPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) solve(scanner);
        scanner.close();
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) v.add(scanner.nextInt());
        Collections.sort(v);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += upperBound(v, r - v.get(i)) - lowerBound(v, l - v.get(i));
            if (l <= 2 * v.get(i) && 2 * v.get(i) <= r) {
                ans--;
            }
        }
        System.out.println(ans / 2);
    }

    static int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
