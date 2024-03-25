// 25 March 2024
// Given an integer array nums, find the
//subarray
// with the largest sum, and return its sum.

package Medium;

public class lc0053_MaximumSubarray {
    // Using Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        // Initialize variables to store the maximum sum and the current sum
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the current sum
            sum += nums[i];

            // Update the maximum sum if the current sum is greater
            if (sum > max) {
                max = sum;
            }

            // If the current sum becomes negative, reset it to zero
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum sum found
        return max;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0053_MaximumSubarray obj = new lc0053_MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
    }
}
