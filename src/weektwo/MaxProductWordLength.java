package weektwo;

/**
 * Used the Brute Force for solving.
 * Then learned the new technique of String Masking.
 * May come in-handy many times.
 */
public class MaxProductWordLength {

    public static int maxProduct(String[] words) {
        int ans = 0;
        int[] masks = new int[words.length];

        for (int i = 0; i < words.length; i++)
            masks[i] = getMask(words[i]);

        for (int i = 0; i < masks.length; i++)
            for (int j = 0; j < i; j++)
                if ((masks[i] & masks[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());

        return ans;
    }

    private static int getMask(final String word) {
        int mask = 0;
        for (char c : word.toCharArray()) mask |= 1 << c - 'a';
        return mask;
    }
}
