package weekone;

import java.util.Arrays;

/**
 * Sorting and looking for possible answers.
 */
public class HIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        int hIndex = -1;
        for (int i = 0; i < n; i++) hIndex = Math.max(hIndex, Math.min(citations[i], n - i));
        return hIndex;
    }

    /**
     * Could have used frequency, since n can be the maximum answer.
     */
    public static int hIndexSolution(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        for (int num : citations) {
            if (num > n) freq[n]++;
            else freq[num]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += freq[i];
            if (sum >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
