package daily.leetcode;

import java.util.PriorityQueue;

public class FurthestBuildingWeCanReach {

    /**
     * One of the craziest questions!
     */
    public static int furthestBuilding(int[] h, int b, int l) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, c) -> c - a);

        int i, diff;
        for (i = 0; i < h.length - 1; i++) {
            diff = h[i + 1] - h[i];
            if (diff <= 0) continue;

            b -= diff;
            p.offer(diff);

            if (b < 0) {
                b += p.poll();
                l--;
            }

            if (l < 0) break;
        }

        return i;
    }
}

