package daily.leetcode;

public class StringHalvesAlike {

    public static boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);

        int countFirst = countVowels(firstHalf);
        int countSecond = countVowels(secondHalf);

        return countFirst == countSecond;
    }

    private static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) count++;
        }
        return count;
    }
}
