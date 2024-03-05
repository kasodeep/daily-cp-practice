package daily.gfg;

public class MaximumIndex {

    public static int maxIndexDiff(int[] a, int n) {
        int i = 0, j = n - 1;
        int max = -1;

        while (i <= j) {
            if (a[i] > a[j]) {
                j--;
            } else {
                max = Math.max(max, j - i);
                j = n - 1;
                i++;
            }
        }
        return max;
    }
}
