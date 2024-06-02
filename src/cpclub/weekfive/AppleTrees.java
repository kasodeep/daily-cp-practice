package cpclub.weekfive;

import java.util.*;

public class AppleTrees {

    static int[] a = new int[200001];
    static List<Integer>[] v = new ArrayList[200001];

    static void DFS(int o, int p) {
        for (int x : v[o]) {
            if (x != p) {
                DFS(x, o);
                a[o] += a[x];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = n - 1;

            while (k-- > 0) {
                int i = sc.nextInt();
                int j = sc.nextInt();

                if (v[i] == null) v[i] = new ArrayList<>();
                if (v[j] == null) v[j] = new ArrayList<>();
                v[i].add(j);
                v[j].add(i);
            }

            for (int i = 2; i <= n; i++) {
                if (v[i] != null && v[i].size() == 1) a[i] = 1;
            }

            DFS(1, 1);
            int m = sc.nextInt();
            while (m-- > 0) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                System.out.println(a[i] * a[j]);
            }

            for (int i = 0; i <= n; i++) {
                if (v[i] != null) v[i].clear();
                a[i] = 0;
            }
        }
    }
}
