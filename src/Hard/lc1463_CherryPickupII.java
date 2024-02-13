// Date: 11 February 2024
// You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents
// the number of cherries that you can collect from the (i, j) cell.

//You have two robots that can collect cherries for you:

//Robot #1 is located at the top-left corner (0, 0), and
//Robot #2 is located at the top-right corner (0, cols - 1).
//Return the maximum number of cherries collection using both robots by following the rules below:

//From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
//When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
//When both robots stay in the same cell, only one takes the cherries.
//Both robots cannot move outside of the grid at any moment.
//Both robots should reach the bottom row in grid.

package Hard;

import java.util.Arrays;

public class lc1463_CherryPickupII {

    // Recursive function with memoization to find maximum cherries picked by two robots
    int m, n; // Dimensions of the grid
    int[][][] t; // Memoization array

    public int solve(int[][] grid, int row, int c1, int c2) {
        // Base case: If robots reach beyond last row, return 0
        if (row >= this.m) {
            return 0;
        }

        // If result for current state is already memoized, return memoized result
        if (t[row][c1][c2] != -1) {
            return t[row][c1][c2];
        }

        // Calculate cherries picked by both robots in current cell
        int cherry = grid[row][c1];
        if (c1 != c2) {
            cherry += grid[row][c2];
        }

        int ans = 0;
        // Iterate over all possible moves for both robots
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Calculate new row and column positions for both robots
                int newRow = row + 1;
                int newC1 = c1 + i;
                int newC2 = c2 + j;

                // If new positions are within grid boundaries, recursively explore them
                if (newC1 >= 0 && newC1 < this.n && newC2 >= 0 && newC2 < this.n) {
                    ans = Math.max(ans, solve(grid, newRow, newC1, newC2));
                }
            }
        }
        // Memoize result for current state and return maximum cherries picked
        return t[row][c1][c2] = cherry + ans;
    }

    // Main function to find maximum cherries picked by two robots
    public int cherryPickupByRecur(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        // Initialize memoization array with -1
        t = new int[71][71][71];
        for (int i = 0; i < 71; i++) {
            for (int j = 0; j < 71; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        // Call recursive function with initial parameters and return result
        return solve(grid, 0, 0, this.n - 1);
    }

    // - - -  -  - - - - - - -  - - - - - - - - - -

    // Bottom-up dynamic programming approach to find maximum cherries collected by two robots
    public int cherryPickupByBU(int[][] grid) {
        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid

        int[][][] t = new int[71][71][71]; // Memoization array to store maximum cherries collected till each cell

        // Initialize the value of t[0][0][n - 1]
        t[0][0][n - 1] = (n == 1) ? grid[0][0] : grid[0][0] + grid[0][n - 1];

        // Iterate over each row starting from the second row
        for (int row = 1; row < m; row++) {
            // Iterate over possible columns for both robots
            for (int c1 = 0; c1 <= Math.min(n - 1, row); c1++) {
                for (int c2 = Math.max(n - row - 1, 0); c2 < n; c2++) {
                    int prevRowMax = 0;
                    // Calculate maximum cherries collected till the current cell considering previous row
                    for (int prevCol1 = Math.max(0, c1 - 1); prevCol1 <= Math.min(c1 + 1, n - 1); prevCol1++) {
                        for (int prevCol2 = Math.max(c2 - 1, 0); prevCol2 <= Math.min(c2 + 1, n - 1); prevCol2++) {
                            prevRowMax = Math.max(prevRowMax, t[row - 1][prevCol1][prevCol2]);
                        }
                    }
                    // Update t[row][c1][c2] based on previous row's max and cherries collected at current cell
                    if (c1 == c2) {
                        t[row][c1][c2] = prevRowMax + grid[row][c1];
                    } else {
                        t[row][c1][c2] = prevRowMax + grid[row][c1] + grid[row][c2];
                    }
                }
            }
        }
        // Find maximum cherries collected till the last row and return as result
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, t[m - 1][i][j]);
            }
        }
        return res;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1463_CherryPickupII obj = new lc1463_CherryPickupII();
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(obj.cherryPickupByRecur(grid));
        System.out.println(obj.cherryPickupByBU(grid));
    }

}
