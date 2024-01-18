// Date: 18 January 2024
// You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

package Easy;

import java.util.Arrays;

public class lc0070_ClimbingStairs extends Solution2  {

    // Main function for testing
    public static void main(String[] args) {
        lc0070_ClimbingStairs obj = new lc0070_ClimbingStairs();
        int n = 5;
        System.out.println(obj.climbStairs(n));
    }
}

// Function to climb stairs using top-down approach with memoization
class Solution1 {
    public int climbStairs(int n) {
        // Memoization array to store computed results
        int[] memo = new int[n + 1];

        // Initialize memo array with -1 to indicate uncompleted values
        Arrays.fill(memo, -1);

        // Call the recursive helper function and return the result
        return climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
    }

    // Helper function for recursive top-down approach with memoization
    private int climbStairsHelper(int n, int[] memo) {
        // Base case: If the current step is negative, no valid ways to climb
        if (n < 0) {
            return 0;
        }

        // Base cases: If on the first or second step, there is only one way to climb
        if (n == 0 || n == 1) {
            // Memoize the result and return
            memo[n] = 1;
            return memo[n];
        }

        // If the result for the current step is already memoized, return it
        if (memo[n] != -1) {
            return memo[n];
        }

        // Recursive calls to climbStairs for the previous two steps, memoize the result
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);

        // Return the memoized result
        return memo[n];
    }
}

// Function to calculate the number of distinct ways to climb stairs using dynamic programming
class Solution2 {
    public int climbStairs(int n) {
        // Dynamic programming array to store distinct ways to climb each step
        int[] dp = new int[n + 1];

        // Base cases: there is one way to climb 0 and 1 step
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dynamic programming array using the iterative approach
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the number of distinct ways to climb to the top
        return dp[n];
    }
}

// Function to calculate the number of distinct ways to climb stairs using an iterative approach
class Solution3 {
    public int climbStairs(int n) {
        // Variables to store the counts for two preceding steps
        int a = 1;
        int b = 1;
        int c;

        // Iterate to calculate the number of distinct ways for each step up to the nth step
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        // Return the number of distinct ways to climb to the top
        return b;
    }
}