package daily.leetcode;

public class MinStepsToAnagram {

    public static int minSteps(String s, String t) {
        int[] charFreq = new int[26];

        for (int idx = 0; idx < s.length(); idx++) {
            charFreq[s.charAt(idx) - 'a']++;
            charFreq[t.charAt(idx) - 'a']--;
        }

        int minSteps = 0;
        for (int idx = 0; idx < 26; idx++) minSteps += Math.max(0, charFreq[idx]);
        return minSteps;
    }
}
