package daily.leetcode;

public class CustomSortString {

    public static String customSortString(String order, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) count[(s.charAt(i) - 'a')]++;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            int c = count[(ch - 'a')];

            count[(ch - 'a')] = 0;
            if (c > 0) builder.append(String.valueOf(ch).repeat(c));
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                char ch = (char) (i + 'a');
                builder.append(String.valueOf(ch).repeat(count[i]));
            }
        }
        return builder.toString();
    }
}
