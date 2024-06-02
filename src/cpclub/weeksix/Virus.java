package cpclub.weeksix;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Virus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] infected = new int[m];
            for (int i = 0; i < m; i++) infected[i] = sc.nextInt();
            Arrays.sort(infected);

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            pq.add(n - infected[m - 1] + infected[0] - 1);

            for (int i = 0; i < m - 1; i++) {
                int e = infected[i + 1] - infected[i] - 1;
                pq.add(e);
            }

            int protect = 0;
            int time = 0;
            while (pq.size() > 0) {
                if (pq.peek() - 2 * time > 0) protect += Math.max(1, pq.peek() - 2 * time - 1);
                pq.poll();
                time += 2;
            }

            System.out.println(n - protect);
        }
    }
}
