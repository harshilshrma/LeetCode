// Date: 4 Aug 2023
// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.
// In computer science, an in-place algorithm is an algorithm that operates directly on the input data
// structure without requiring extra space proportional to the input size.

package Medium;

import java.util.Arrays;

public class lc0073_SetMatrixZeroes {
    static boolean setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return false;
    }

    static boolean setZeroesOptimaal(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;

//        int[] row = new int[m]; --> matrix[..][0]
//        int[] col = new int[n]; --> matrix[0][..]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // mark the i-th row
                    matrix[i][0] = 0;

                    //mark the j-th col
                    if (j != 0) {
                        matrix[0][j] = 0;

                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    // check for col and row
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }

            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {0, 1, 2}
        };
        System.out.println(setZeroes(arr));
        System.out.println(setZeroesOptimaal(arr));
    }
}
