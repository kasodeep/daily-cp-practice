package daily.gfg;

public class WaterThePlants {

    public static int min_sprinklers(int[] arr, int n) {
        int[] arr2 = new int[n];
        for (int j = 0; j < n; j++) {
            if (arr[j] == -1) continue;
            int st = Math.max(0, j - arr[j]), end = Math.min(n - 1, j + arr[j]);
            arr2[st] = Math.max(arr2[st], end);
        }

        for (int j = 1; j < n; j++) {
            arr2[j] = Math.max(arr2[j], arr2[j - 1]);
        }

        int cnt = 0, in = 0;
        while (in < n) {
            cnt++;
            if (in > arr2[in]) return -1;
            in = arr2[in] + 1;
        }
        return cnt;
    }
}
