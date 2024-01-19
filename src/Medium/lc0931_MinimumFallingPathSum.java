// Date: 19 January 2024
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

//A falling path starts at any element in the first row and chooses the element in the next row that is either
// directly below or diagonally left/right. Specifically, the next element from position (row, col) will
// be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc0931_MinimumFallingPathSum {

//    public int n;
//    public int[][] t = new int[101][101];
//
//    public int solve(int[][] matrix, int row, int col) {
//        if (row == n - 1) {
//            return matrix[row][col];
//        }
//
//        if (t[row][col] != -1) {
//            return t[row][col];
//        }
//
//        int minSum = Integer.MAX_VALUE;
//        int sum = matrix[row][col];
//
//        for (int shift = -1; shift <= 1; shift++) {
//            if (row + 1 < n && col + shift < n && col + shift >= 0) {
//                minSum = Math.min(minSum, (sum + solve(matrix, row + 1, col + shift)));
//            }
//        }
//
//        t[row][col] = minSum;
//
//        return minSum;
//    }
//
//    public int minFallingPathSum(int[][] matrix) {
//        n = matrix.length;
//        for (int i = 0; i < 101; i++) {
//            Arrays.fill(t[i], -1);
//        }
//
//        int row = 0;
//        int result = Integer.MAX_VALUE;
//        for (int col = 0; col < n; col++) {
//            result = Math.min(result, solve(matrix, row, col));
//        }
//
//        return result;
//    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Create a new matrix to store intermediate results
        int[][] arr = new int[n][n];

        // Initialize the first row of the new matrix with values from the original matrix
        for (int col = 0; col < n; col++) {
            arr[0][col] = matrix[0][col];
        }

        // Iterate through each row starting from the second row
        for (int row = 1; row < n; row++) {
            // Iterate through each column in the current row
            for (int col = 0; col < n; col++) {
                // Initialize variables to store values from neighboring positions
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;

                // Check if the left neighbor exists
                if (col - 1 >= 0) {
                    a = arr[row - 1][col - 1];
                }

                // Check if the right neighbor exists
                if (col + 1 < n) {
                    b = arr[row - 1][col + 1];
                }

                // Calculate the minimum falling path sum for the current position
                arr[row][col] = matrix[row][col] + Math.min(a, Math.min(b, arr[row - 1][col]));
            }
        }

        // Find the minimum falling path sum in the last row of the new matrix
        int result = Integer.MAX_VALUE;
        int lastRow = n - 1;
        for (int col = 0; col < n; col++) {
            result = Math.min(result, arr[lastRow][col]);
        }

        // Return the minimum falling path sum
        return result;
    }


    // Main function for testing:
    public static void main(String[] args) {
        lc0931_MinimumFallingPathSum obj = new lc0931_MinimumFallingPathSum();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(obj.minFallingPathSum(matrix));
    }
}
