// Date: 9 February 2024
// Given a set of distinct positive integers nums, return the largest subset answer such that every pair
// (answer[i], answer[j]) of elements in this subset satisfies:
//answer[i] % answer[j] == 0, or
//answer[j] % answer[i] == 0
//If there are multiple solutions, return any of them.

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc0368_LargestDivisibleSubset {

    // Recursive function to find the largest divisible subset
    public void solve(int idx, int[] nums, List<Integer> result, List<Integer> temp, int prev) {
        // Base case: if index exceeds array length
        if (idx >= nums.length) {
            // Check if current subset is larger than result
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }
            return;
        }

        // Include current element if divisible by previous or prev is -1
        if (prev == -1 || nums[idx] % prev == 0) {
            // Include current element
            temp.add(nums[idx]);

            // Recur with current element included
            solve(idx + 1, nums, result, temp, nums[idx]);

            // Backtrack: Remove current element from subset
            temp.remove(temp.size() - 1);
        }

        // Recur without including current element
        solve(idx + 1, nums, result, temp, prev);
    }

    // Main function to find the largest divisible subset
    public List<Integer> largestDivisibleSubsetByRecur(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);

        // Initialize lists to store result and current subset
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        // Initialize previous element variable
        int prev = -1;

        // Call recursive function to find largest divisible subset
        solve(0, nums, result, temp, prev);

        // Return the largest divisible subset
        return result;
    }


    // Bottom Up
    public List<Integer> largestDivisibleSubsetByBU(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int[] prevIdx = new int[nums.length];
        Arrays.fill(prevIdx, -1);

        int lastChosenIdx = 0;
        int maxL = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // took i th element
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prevIdx[i] = j;
                    }

                    if (dp[i] > maxL) {
                        maxL = dp[i];
                        lastChosenIdx = i;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (lastChosenIdx != -1) {
            res.add(nums[lastChosenIdx]);
            lastChosenIdx = prevIdx[lastChosenIdx];
        }

        return res;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0368_LargestDivisibleSubset obj = new lc0368_LargestDivisibleSubset();
        int[] nums = {3, 8, 15, 32, 64};
        System.out.println(obj.largestDivisibleSubsetByRecur(nums));
        System.out.println(obj.largestDivisibleSubsetByBU(nums));
    }
}
