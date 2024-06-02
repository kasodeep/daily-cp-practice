package cpclub.weeksix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SynchronizedPlayers {

    static final int inf = 1000000010;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[][] s = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = scanner.next().charAt(0);
            }
        }

        int[][][][] dis = new int[n][n][n][n];
        for (int[][][] arr1 : dis) {
            for (int[][] arr2 : arr1) {
                for (int[] arr3 : arr2) Arrays.fill(arr3, inf);
            }
        }

        // Find the coordinates, of each player.
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j] == 'P') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }

        Queue<int[]> que = new LinkedList<>();
        dis[x1][y1][x2][y2] = 0;
        que.offer(new int[]{x1, y1, x2, y2});
        while (!que.isEmpty()) {

            int[] ar = que.poll();
            for (int d = 0; d < 4; d++) {
                int[] nxt = Arrays.copyOf(ar, 4);

                // It goes out or doesn't move.
                nxt[0] += dx[d];
                nxt[1] += dy[d];
                if (nxt[0] < 0 || nxt[0] >= n || nxt[1] < 0 || nxt[1] >= n || s[nxt[0]][nxt[1]] == '#') {
                    nxt[0] = ar[0];
                    nxt[1] = ar[1];
                }
                nxt[2] += dx[d];
                nxt[3] += dy[d];
                if (nxt[2] < 0 || nxt[2] >= n || nxt[3] < 0 || nxt[3] >= n || s[nxt[2]][nxt[3]] == '#') {
                    nxt[2] = ar[2];
                    nxt[3] = ar[3];
                }

                if (dis[nxt[0]][nxt[1]][nxt[2]][nxt[3]] == inf) {
                    dis[nxt[0]][nxt[1]][nxt[2]][nxt[3]] = dis[ar[0]][ar[1]][ar[2]][ar[3]] + 1;
                    que.offer(nxt);
                }
            }
        }

        int ans = inf;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, dis[i][j][i][j]);
            }
        }
        System.out.println(ans == inf ? -1 : ans);
    }
}
