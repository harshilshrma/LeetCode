// 12-05-2024 - 11:22 pm
// 

package Easy;

import java.util.Arrays;

public class lc2372_LargestLocalValuesInAMatrix {
    // Function
    public static int findMax (int[][] grid, int row, int col) {
        int maxval = -1;

        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                maxval = Math.max(maxval, grid[i][j]);
            }
        }


        return maxval;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];

        for (int row = 0; row < n - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                ans[row][col] = findMax(grid, row, col);
            }
        }

        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2372_LargestLocalValuesInAMatrix obj = new lc2372_LargestLocalValuesInAMatrix();
        int[][] grid = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        System.out.println(Arrays.deepToString(obj.largestLocal(grid)));
    }
}



