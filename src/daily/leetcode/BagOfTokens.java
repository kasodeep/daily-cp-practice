package daily.leetcode;

import java.util.Arrays;

public class BagOfTokens {

    public static int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        if (n == 0 || power < tokens[0]) return 0;

        int score = 1;
        int maxScore = 1;
        power -= tokens[0];

        int j = n - 1;
        for (int i = 1; i <= j; i++) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
            } else {
                if (score >= 1) {
                    power += tokens[j--] - tokens[i];
                } else {
                    break;
                }
            }
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }
}
