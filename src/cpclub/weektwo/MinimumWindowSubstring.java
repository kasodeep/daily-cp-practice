package cpclub.weektwo;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                if (map.get(s.charAt(end)) > 0) counter--;
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }

            end++;
            while (counter == 0) {
                if (end - begin < d) {
                    d = end - (head = begin);
                }

                if (map.containsKey(s.charAt(begin))) {
                    map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
                    if (map.get(s.charAt(begin)) > 0) counter++;
                }
                begin++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
