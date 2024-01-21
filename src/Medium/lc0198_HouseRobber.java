// Date: 21 January 2024
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of
// money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
// security systems connected and it will automatically contact the police if two adjacent houses were broken
// into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money
// you can rob tonight without alerting the police.

package Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lc0198_HouseRobber {
    private int[] t;

    // Recursive function to find the maximum amount that can be robbed
    public int solve(int[] nums, int i, int n) {
        // Base case: if the index is beyond the array size, return 0
        if (i >= n) {
            return 0;
        }

        // Memoization: return the precomputed result if available
        if (t[i] != -1) {
            return t[i];
        }

        // Choose between stealing from the current house or skipping to the next one
        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        // Update the memoization table with the maximum amount for the current index
        return t[i] = Math.max(steal, skip);
    }

    // Main function to calculate the maximum amount that can be robbed
    public int rob(int[] nums) {
        int n = nums.length;

        // Initialize the memoization table with -1
        t = new int[101];
        Arrays.fill(t, -1);

        // Call the recursive function starting from the first house (index 0)
        return solve(nums, 0, n);
    }

    public int robByBottomUp(int[] nums) {
        int n = nums.length;
        // Dynamic Programming Table
        int[] t = new int[n + 1];
        Arrays.fill(t, 0);

        // Base Case: Return the value of the single house if there is only one
        if (n == 1) {
            return nums[0];
        }

        // Initialization for the first two houses
        t[0] = 0;
        t[1] = nums[0];

        // Dynamic Programming Loop
        for (int i = 2; i <= n; i++) {
            // Choose between stealing from the current house or skipping to the next one
            int steal = nums[i - 1] + t[i - 2];
            int skip = t[i - 1];

            // Update the dynamic programming table with the maximum amount for the current index
            t[i] = Math.max(steal, skip);
        }

        // Return the maximum amount that can be robbed from the last house
        return t[n];
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0198_HouseRobber obj = new lc0198_HouseRobber();
        int[] nums = {2, 1, 1, 2};
        System.out.println(obj.robByBottomUp(nums));
    }
}
