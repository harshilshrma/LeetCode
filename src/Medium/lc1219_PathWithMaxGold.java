// 14-05-2024 - 12:49 pm
// In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold
// in that cell, 0 if it is empty.
//
//Return the maximum amount of gold you can collect under the conditions:
//
//Every time you are located in a cell you will collect all the gold in that cell.
//From your position, you can walk one step to the left, right, up, or down.
//You can't visit the same cell more than once.
//Never visit a cell with 0 gold.
//You can start and stop collecting gold from any position in the grid that has some gold.

package Medium;

public class lc1219_PathWithMaxGold {

    // Functions
    public static int dfs(int[][] grid, int i, int j) {
        // for up, down, right, left RESPECTIVELY
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
            return 0;
        }

        int originalGoldValue = grid[i][j];
        grid[i][j] = 0;

        int maxGold = 0;

        //up down left right
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            maxGold = Math.max(maxGold, dfs(grid, new_i, new_j));
        }


        grid[i][j] = originalGoldValue;
        return originalGoldValue + maxGold;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxGold = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc1219_PathWithMaxGold obj = new lc1219_PathWithMaxGold();
        int[][] grid = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(obj.getMaximumGold(grid));
    }
}



