package daily.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char character = entry.getKey();
            int frequency = entry.getValue();
            sb.append(String.valueOf(character).repeat(Math.max(0, frequency)));
        }
        return sb.toString();
    }
}
