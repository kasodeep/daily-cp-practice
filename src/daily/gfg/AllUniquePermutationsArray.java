package daily.gfg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutationsArray {

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Set<ArrayList<Integer>> ans = new HashSet<>();
        solve(arr, 0, n - 1, ans);

        // LexoGraphical Sorting.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(ans);
        result.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return result;
    }

    static void solve(ArrayList<Integer> arr, int start, int end, Set<ArrayList<Integer>> ans) {
        if (start == end) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                solve(new ArrayList<>(arr), start + 1, end, ans);
                swap(arr, start, i);
            }
        }
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
