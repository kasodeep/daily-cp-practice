package cpclub.weeksix;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;

        while (start < end) {
            int mid = (start + end) / 2;
            if (x - arr[mid] > arr[mid + k] - x) start = mid + 1;
            else end = mid;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < start + k; i++) result.add(arr[i]);
        return result;
    }
}
