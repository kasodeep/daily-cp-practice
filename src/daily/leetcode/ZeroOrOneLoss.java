package daily.leetcode;

import java.util.*;

public class ZeroOrOneLoss {

    public static List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winner = new HashSet<>();
        Map<Integer, Integer> loser = new HashMap<>();

        List<Integer> notLost = new ArrayList<>();
        List<Integer> lost1Match = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] match : matches) {
            winner.add(match[0]);
            loser.put(match[1], loser.getOrDefault(match[1], 0) + 1);
        }

        for (int w : winner) {
            if (!loser.containsKey(w)) notLost.add(w);
        }
        for (int l : loser.keySet()) {
            if (loser.get(l) == 1) lost1Match.add(l);
        }

        Collections.sort(notLost);
        Collections.sort(lost1Match);
        ans.add(notLost);
        ans.add(lost1Match);
        return ans;
    }
}
