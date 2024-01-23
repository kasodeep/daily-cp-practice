package daily.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        int[] inDegree = new int[n];

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (ArrayList<Integer> prerequisite : prerequisites) {
            graph[prerequisite.get(1)].add(prerequisite.get(0));
            inDegree[prerequisite.get(0)]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int[] order = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;

            for (int adjacent : graph[node]) {
                inDegree[adjacent]--;
                if (inDegree[adjacent] == 0) queue.add(adjacent);
            }
        }

        if (index != n) return new int[0];
        return order;
    }
}
