package daily.gfg;

import java.util.ArrayList;
import java.util.HashSet;

public class DuplicateRows {

    public static ArrayList<Integer> repeatedRows(int[][] matrix, int m, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) temp.append(matrix[i][j]);

            if (set.contains(temp.toString())) ans.add(i);
            set.add(temp.toString());
        }
        return ans;
    }
}
