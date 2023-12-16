// Date: 12 December 2023
// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.

package Medium;

public class lc0074_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // For empty input
        if (matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        // Finding the row
        int top = 0;
        int bottom = m - 1;

        while (top <= bottom) {
            int row = top + ((bottom - top) / 2);
            if (target > matrix[row][n-1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                break;
            }
        }

        // For the condition when
        if (top > bottom) return false;

        // Applying binary search in the obtained row, after the above while loop
        int row = top + ((bottom - top) / 2);
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (target > matrix[row][mid]){
                l = mid + 1;
            } else if (target < matrix[row][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0074_SearchA2DMatrix obj = new lc0074_SearchA2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(obj.searchMatrix(matrix, target));
    }
}
