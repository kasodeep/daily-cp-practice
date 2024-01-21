package leetcode;

public class CountHousesAtDistanceI {

    public static int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int directDistance = j - i;
                int viaXYDistance = Math.min(Math.abs(x - i) + 1 + Math.abs(y - j), Math.abs(y - i) + 1 + Math.abs(x - j));

                int minDistance = Math.min(directDistance, viaXYDistance);
                result[minDistance - 1]++;
            }
        }

        for (int i = 0; i < n; i++) result[i] *= 2;
        return result;
    }
}
