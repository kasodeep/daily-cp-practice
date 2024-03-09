package daily.leetcode;

public class MinimumCommonValue {
    public static int getCommon(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j])
                return a[i];
            else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return -1;
    }
}
