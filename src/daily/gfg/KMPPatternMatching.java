package daily.gfg;

import java.util.ArrayList;

/**
 * Algorithm that runs in O(M + N) and avoids unnecessary comparing.
 */
public class KMPPatternMatching {

    // Function to compute the Longest Proper Prefix which is also Suffix (LPS) array.
    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0; // Length of the previous longest prefix suffix.
        int i;

        lps[0] = 0; // lps[0] is always 0
        i = 1;

        // Loop to compute the LPS array.
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to search for the pattern in the given text.
    private static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M + 1];
        int j = 0; // Index for pattern.
        computeLPSArray(pat, M, lps);

        int f = 0; // Flag to track if the pattern was found.
        int i = 0; // Index for text.

        // Loop to search for the pattern in the text.
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                f++; // Increment the flag.
                res.add(i - j + 1); // Add the index where the pattern is found to the result list.
                j = lps[j - 1]; // Update j to continue searching for more occurrences of the pattern.
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1]; // Update j based on lps array.
                else
                    i = i + 1; // Increment i if j is 0
            }
        }

        if (f == 0) res.add(-1);
        return res;
    }
}
