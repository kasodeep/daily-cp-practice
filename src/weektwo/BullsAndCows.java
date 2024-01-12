package weektwo;

import java.util.HashMap;

/**
 * Frequency and Mapping trick.
 * */
public class BullsAndCows {

    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : secret.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

        int cows = 0;
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sh = secret.charAt(i);
            char gh = guess.charAt(i);

            if (sh == gh) {
                bulls++;
                if (map.get(sh) <= 0) cows--;
                else map.put(sh, map.get(sh) - 1);
            } else {
                if (map.containsKey(gh) && map.get(gh) > 0) {
                    cows++;
                    map.put(gh, map.get(gh) - 1);
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}
