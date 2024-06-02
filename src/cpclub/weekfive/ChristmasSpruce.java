package cpclub.weekfive;

import java.util.Scanner;

public class ChristmasSpruce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] p = new int[n];
        int[] deg = new int[n];
        for (int i = 1; i < n; i++) {
            p[i] = sc.nextInt() - 1;
            deg[p[i]]++;
        }

        int[] sonsLeaves = new int[n];
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) sonsLeaves[p[i]]++;
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (deg[i] > 0 && sonsLeaves[i] < 3) {
                System.out.println("No");
                flag = false;
                break;
            }
        }

        if (flag) System.out.println("Yes");
    }
}
