package cpclub.weekfour;

import java.util.ArrayList;
import java.util.Scanner;

public class PermutationTransformation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(-1);

            solve(0, n - 1, arr, 0, list);
            for (int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int i, int j, int[] arr, int level, ArrayList<Integer> list) {
        if (i > j) return;

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int k = i; k <= j; k++) {
            if (max < arr[k]) {
                max = arr[k];
                maxIdx = k;
            }
        }

        list.set(maxIdx, level);
        solve(i, maxIdx - 1, arr, level + 1, list);
        solve(maxIdx + 1, j, arr, level + 1, list);
    }
}
