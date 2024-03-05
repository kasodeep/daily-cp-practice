package daily.leetcode;

public class DeletingSimilarEnds {

    public static int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (ch[i] == ch[j]) {
                i++;
                while (i < j && ch[i] == ch[i - 1]) i++;
                j--;
                while (j > i && ch[j] == ch[j + 1]) j--;
            } else {
                break;
            }
        }

        if (i < j) return j - i + 1;
        return i == j ? 1 : 0;
    }
}
