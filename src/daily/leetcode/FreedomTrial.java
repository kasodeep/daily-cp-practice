package daily.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrial {

    static Map<Character, List<Integer>> charToIndex = new HashMap<>();
    static int[][] memo;

    public static int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        memo = new int[m][n];

        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) charToIndex.put(c, new ArrayList<>());
            charToIndex.get(c).add(i);
        }

        return dp(ring, 0, key, 0, m);
    }

    private static int dp(String ring, int i, String key, int j, int m) {
        if (j == key.length()) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int tmp = Integer.MAX_VALUE;
        for (int idx : charToIndex.get(key.charAt(j))) {
            int delta = Math.abs(idx - i);
            delta = Math.min(delta, m - delta);

            int subProblem = dp(ring, idx, key, j + 1, m);
            tmp = Math.min(delta + subProblem + 1, tmp);
        }
        memo[i][j] = tmp;
        return tmp;
    }
}
