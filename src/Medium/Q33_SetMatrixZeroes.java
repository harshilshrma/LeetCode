// Date: 4 Aug 2023
// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.
// In computer science, an in-place algorithm is an algorithm that operates directly on the input data
// structure without requiring extra space proportional to the input size.

package Medium;

import java.util.Arrays;

public class Q33_SetMatrixZeroes {
    //Brute Force
    public int[][] setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    markRow(i, matrix);
                    markCol(j, matrix);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
        return matrix;
    }
    void markRow(int i, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] != 0) matrix[i][j] = -1;
        }
    }
    void markCol(int j, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] != 0) matrix[i][j] = -1;
        }
    }

    // Better Solution
    publ


    public static void main(String[] args) {
        Q33_SetMatrixZeroes obj1 = new Q33_SetMatrixZeroes();
        int[][] array = new int[][] {
                {-1, 2, 3},
        };
        System.out.println(Arrays.deepToString(obj1.setZeroes(array)));
    }
}
