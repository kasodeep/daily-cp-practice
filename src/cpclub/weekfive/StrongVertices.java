package cpclub.weekfive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrongVertices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = a[i] - b[i];
                max = Math.max(max, a[i]);
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) if (a[i] == max) list.add(i + 1);

            System.out.println(list.size());
            for(int num : list) System.out.print(num + " ");
            System.out.println();
        }
    }
}
