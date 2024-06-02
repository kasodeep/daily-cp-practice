package cpclub.weekseven;

import java.util.*;

public class WordBreak2 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);

        helper(res, s, new ArrayList<>(), set, 0);
        return res;
    }

    public static void helper(List<String> res, String s, List<String> list, Set<String> set, int index) {
        if (index == s.length()) {
            res.add(String.join(" ", list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (set.contains(sub)) {
                list.add(sub);
                helper(res, s, list, set, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
