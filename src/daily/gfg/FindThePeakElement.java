package daily.gfg;

public class FindThePeakElement {

    public int peakElement(int[] arr, int n) {
        if (n == 1) return 0;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= arr[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
