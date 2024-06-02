package cpclub.weeksix;

import java.util.ArrayList;
import java.util.Scanner;

public class LittleAlawnPuzzle {

    static boolean[] gone;
    static ArrayList<Integer>[] adj;
    static int[][] arr;

    static void dfs(int loc) {
        gone[loc] = true;
        for (int x : adj[loc]) {
            if (!gone[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();

            arr = new int[n + 1][2];
            gone = new boolean[n + 1];
            adj = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i][0] = sc.nextInt();
                adj[i] = new ArrayList<>();
                gone[i] = false;
            }

            for (int i = 1; i <= n; i++) {
                arr[i][1] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                adj[arr[i][0]].add(arr[i][1]);
                adj[arr[i][1]].add(arr[i][0]);
            }

            long ans = 1;
            for (int i = 1; i <= n; i++) {
                if (!gone[i]) {
                    ans = ans * 2 % 1000000007;
                    dfs(i);
                }
            }
            System.out.println(ans);
        }
    }
}
