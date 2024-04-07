// 8 April 2024
// Given an m x n matrix, return all elements of the matrix in spiral order.

package Medium;

import java.util.ArrayList;
import java.util.List;

public class lc0054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] mat) {
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();

        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns

        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0054_SpiralMatrix obj = new lc0054_SpiralMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(obj.spiralOrder(matrix));
    }
}
