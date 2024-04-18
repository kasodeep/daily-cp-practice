package daily.gfg;

public class FindTwoRepeated {

    public static int[] twoRepeated(int[] arr, int n) {
        int[] res = new int[2];
        int resi = 0;

        for (int i = 0; i < n + 2; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] < 0) res[resi++] = index;
            else arr[index] *= -1;
        }
        return res;
    }
}
