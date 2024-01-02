package weekone;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int leftCol = 0, rightCol = n - 1;
        int topRow = 0, bottomRow = m - 1;

        while (leftCol <= rightCol && topRow <= bottomRow) {
            for (int i = leftCol; i <= rightCol && list.size() < m * n; i++)
                list.add(matrix[topRow][i]);
            topRow++;

            for (int i = topRow; i <= bottomRow && list.size() < m * n; i++)
                list.add(matrix[i][rightCol]);
            rightCol--;

            for (int i = rightCol; i >= leftCol && list.size() < m * n; i--)
                list.add(matrix[bottomRow][i]);
            bottomRow--;

            for (int i = bottomRow; i >= topRow && list.size() < m * n; i--)
                list.add(matrix[i][leftCol]);
            leftCol++;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
