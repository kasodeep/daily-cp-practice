package weekthree;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, h = row * col - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int val = matrix[mid / col][mid % col];

            if (val == target) return true;
            if (val < target) l = mid + 1;
            else h = mid - 1;
        }
        return false;
    }
}

