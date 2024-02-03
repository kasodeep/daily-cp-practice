package weekfour;

import java.util.Arrays;
import java.util.Scanner;

public class MashaAndBeautifulTree {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) arr[i] = sc.nextInt();

            count = 0;
            System.out.println(mergeSort(arr, 0, m - 1) ? count : -1);
        }
    }

    private static boolean mergeSort(int[] arr, int i, int j) {
        if (i >= j) return true;
        int mid = (i + j) / 2;

        boolean left = mergeSort(arr, i, mid);
        boolean right = mergeSort(arr, mid + 1, j);
        if (!left || !right) return false;

        for (int st = i; st < j; st++) {
            if (arr[st] > arr[st + 1]) {
                count++;
                break;
            }
        }

        Arrays.sort(arr, i, j + 1);
        for (int st = i; st < j; st++)
            if (Math.abs(arr[st] - arr[st + 1]) > 1) return false;
        return true;
    }
}
