package daily.gfg;

import java.util.ArrayList;

public class UnionOfTwoSorted {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            int x = arr1[i];
            int y = arr2[j];

            if (x < y) {
                ans.add(x);
                while (i < n && arr1[i] == x) i++;
            } else if (x == y) {
                ans.add(x);
                while (i < n && arr1[i] == x) i++;
                while (j < m && arr2[j] == y) j++;
            } else {
                ans.add(y);
                while (j < m && arr2[j] == y) j++;
            }
        }

        while (i < n) {
            int x = arr1[i];
            ans.add(x);
            while (i < n && arr1[i] == x) i++;
        }

        while (j < m) {
            int y = arr2[j];
            ans.add(y);
            while (j < m && arr2[j] == y) j++;
        }

        return ans;
    }
}
