// Date: 3 February 2024
// Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
// After partitioning, each subarray has their values changed to become the maximum value of that subarray.
// Return the largest sum of the given array after partitioning. Test cases are generated so that the answer
// fits in a 32-bit integer.

package Medium;

import java.util.Arrays;

public class lc1043_PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioningByRecur(int[] arr, int k) {
        // Memo array to store computed results
        int[] memo = new int[501];
        Arrays.fill(memo, -1);

        // Call the recursive function
        return solve(0, arr, k, memo);
    }

    // Recursive helper function to calculate the maximum sum
    private int solve(int i, int[] arr, int k, int[] memo) {
        // Base case: If the current index exceeds the array length, return 0
        if (i >= arr.length) {
            return 0;
        }

        // If result for the current index is already computed, return it
        if (memo[i] != -1) {
            return memo[i];
        }

        // Initialize result and current maximum
        int result = 0;
        int currMax = -1;

        // Iterate over the array, considering subarrays up to length k
        for (int j = i; j < arr.length && j - i + 1 <= k; j++) {
            currMax = Math.max(currMax, arr[j]);

            // Current sub-array is arr[i to j]
            // Update result by considering the sum and recursive call for the next partition
            result = Math.max(result, ((j - i + 1) * currMax) + solve(j + 1, arr, k, memo));
        }

        // Memoize the result for the current index
        return memo[i] = result;
    }
//----------------------------------------------------------------------------------------------------------------------

    // By Bottom Up
    public int maxSumAfterPartitioningByBU(int[] arr, int k) {
        // Length of the input array
        int n = arr.length;

        // t[i] represents the maximum sum by partitioning the array of size i
        int[] t = new int[n + 1];
        Arrays.fill(t, 0);

        // Iterate over different sub-array sizes
        for (int size = 1; size <= n; size++) {
            // Variable to track the maximum element within the current partition
            int currMax = -1;

            // Iterate over possible partition sizes (up to k) for the current sub-array size
            for (int j = 1; j <= k && size - j >= 0; j++) {
                // Update the current maximum element
                currMax = Math.max(currMax, arr[size - j]);

                // Update the maximum sum for the current sub-array size
                t[size] = Math.max(t[size], (j * currMax) + t[size - j]);
            }
        }
        // Return the maximum sum for the entire array
        return t[n];
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1043_PartitionArrayForMaximumSum obj = new lc1043_PartitionArrayForMaximumSum();
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(obj.maxSumAfterPartitioningByRecur(arr, k));
        System.out.println(obj.maxSumAfterPartitioningByBU(arr, k));
    }
}
