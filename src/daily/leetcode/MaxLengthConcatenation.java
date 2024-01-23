package daily.leetcode;

import java.util.HashSet;
import java.util.List;

public class MaxLengthConcatenation {

    static int ans = 0;

    public static int maxLength(List<String> arr) {
        ans = 0;
        int n = arr.size();

        solve(0, n, arr, "");
        return ans;
    }

    public static void solve(int i, int n, List<String> arr, String str) {
        if (i == n) {
            ans = Math.max(ans, str.length());
            return;
        }

        int temp = getMask(arr.get(i));
        if (temp != 0 && (getMask(str) & temp) == 0) solve(i + 1, n, arr, str + arr.get(i));
        solve(i + 1, n, arr, str);
    }

    private static int getMask(String word) {
        int mask = 0;
        HashSet<Character> set = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (set.contains(c)) return 0;
            mask |= 1 << c - 'a';
            set.add(c);
        }
        return mask;
    }
}
