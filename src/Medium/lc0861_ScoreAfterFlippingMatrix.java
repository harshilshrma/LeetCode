// 13-05-2024 - 04:48 pm
// You are given an m x n binary matrix grid.
//
//A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
//
//Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
//
//Return the highest possible score after making any number of moves (including zero moves).

package Medium;

import java.util.Arrays;

public class lc0861_ScoreAfterFlippingMatrix {
    // Functions

    public static void toggleRows(int[][] grid, int row) {
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[row][col] == 0) grid[row][col] = 1;
            else grid[row][col] = 0;
        }
    }

    public static void toggleColumns(int[][] grid, int col) {
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][col] == 0) grid[row][col] = 1;
            else grid[row][col] = 0;
        }
    }

    public static int counter(int[][] grid) {
        int sum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                sum += grid[row][col] * (int) Math.pow(2, grid.length - col - 1);
            }
            System.out.println(sum);
        }

        return sum;
    }


    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        System.out.println(Arrays.deepToString(grid));

        for (int row = 0; row < m; row++) {
            if (grid[row][0] != 1) {
                toggleRows(grid, row);
            }
        }

        for (int col = 0; col < n; col++) {
            int cnt0 = 0, cnt1 = 0;

            for (int row = 0; row < m; row++) {
                if (grid[row][col] == 0) {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }

            if (cnt0 > cnt1) toggleColumns(grid, col);
        }

        System.out.println(Arrays.deepToString(grid));

        return counter(grid);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0861_ScoreAfterFlippingMatrix obj = new lc0861_ScoreAfterFlippingMatrix();
        int[][] grid = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(obj.matrixScore(grid));
    }
}



