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

    public void solve(int idx, int[] nums, List<Integer> result, List<Integer> temp, int prev) {

        if (idx >= nums.length) {
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }
            return;
        }

        // Take option
        if (prev == -1 || nums[idx] % prev == 0) {
            // take
            temp.add(nums[idx]);

            //recur
            solve(idx + 1, nums, result, temp, nums[idx]);

            //not take
            temp.remove(temp.size() - 1);
        }
        solve(idx + 1, nums, result, temp, prev);
    }

    // Recursion Approach
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int prev = -1;

        solve(0, nums, result, temp, prev);

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
        System.out.println(obj.largestDivisibleSubset(nums));
        System.out.println(obj.largestDivisibleSubsetByBU(nums));
    }
}
