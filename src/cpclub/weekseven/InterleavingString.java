package cpclub.weekseven;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return find(s1, s2, 0, 0, s3, memo);
    }

    public static boolean find(String s1, String s2, int i1, int i2, String s3, Boolean[][] memo) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }
        if (memo[i1][i2] != null) {
            return memo[i1][i2];
        }

        boolean valid = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2)) {
            valid |= find(s1, s2, i1 + 1, i2, s3, memo);
        }
        if (!valid && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2)) {
            valid |= find(s1, s2, i1, i2 + 1, s3, memo);
        }
        memo[i1][i2] = valid;
        return valid;
    }
}
