// Date: 26 January 2024
// There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
// You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid
// crossing the grid boundary). You can apply at most maxMove moves to the ball.

//Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball
// out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

package Medium;

public class lc0576_OutOfBoundaryPaths {
    // Memoization array to store computed results
    Integer[][][] dp;
    int mod = 1_000_000_000 + 7;
    int m, n;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Initialize the memoization array
        dp = new Integer[m][n][maxMove + 1];
        this.m = m;
        this.n = n;
        // Call the helper function to compute the result
        return helper(maxMove, startRow, startColumn);
    }

    // Recursive helper function with memoization
    public int helper(int maxMove, int startRow, int startCol) {
        // Base case: if the ball is out of bounds, return 1 path
        if (startRow < 0 || startRow >= m || startCol < 0 || startCol >= n) return 1;

        // Base case: if there are no more moves, return 0 paths
        if (maxMove <= 0) return 0;

        // If the result for the current state is already memoized, return the memoized result
        if (dp[startRow][startCol][maxMove] != null) return dp[startRow][startCol][maxMove];

        int res = 0;
        // Recursively explore all possible moves in four directions (up, down, left, right)
        res = (res + helper(maxMove - 1, startRow + 1, startCol)) % mod;
        res = (res + helper(maxMove - 1, startRow, startCol - 1)) % mod;
        res = (res + helper(maxMove - 1, startRow - 1, startCol)) % mod;
        res = (res + helper(maxMove - 1, startRow, startCol + 1)) % mod;
        // Memoize the result for the current state
        dp[startRow][startCol][maxMove] = res;

        // Return the computed result
        return res;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0576_OutOfBoundaryPaths obj = new lc0576_OutOfBoundaryPaths();
        int m = 45, n = 35, maxMove = 47, startRow = 20, startColumn = 31;
        System.out.println(obj.findPaths(m, n, maxMove, startRow, startColumn));
    }
}
