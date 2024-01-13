package weektwo;

import java.util.Arrays;
import java.util.Comparator;

public class MinTimeForAllTasks {

    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t[1]));
        boolean[] visited = new boolean[2010];
        int count = 0;

        for (int[] task : tasks) {
            int nums = 0;
            for (int j = task[0]; j <= task[1]; j++) {
                if (visited[j]) nums++;
            }

            int j = task[1];
            while (nums < task[2]) {
                if (!visited[j]) {
                    count++;
                    nums++;
                    visited[j] = true;
                }
                j--;
            }
        }
        return count;
    }
}

