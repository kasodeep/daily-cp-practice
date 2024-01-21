package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfPushesToTypeWord {

    public static int minimumPushes(String word) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : word.toCharArray()) frequency.put(c, frequency.getOrDefault(c, 0) + 1);

        List<Character> chars = new ArrayList<>(frequency.keySet());
        chars.sort((a, b) -> frequency.get(b) - frequency.get(a));

        int totalKeyPresses = 0;
        Map<Character, Integer> charToKeyPresses = new HashMap<>();

        for (int i = 0; i < chars.size(); i++) {
            if (i < 8) totalKeyPresses += (frequency.get(chars.get(i)));
            else if (i < 16) totalKeyPresses += (2 * frequency.get(chars.get(i)));
            else if (i < 24) totalKeyPresses += (3 * frequency.get(chars.get(i)));
            else totalKeyPresses += (4 * frequency.get(chars.get(i)));
        }
        return totalKeyPresses;
    }
}
