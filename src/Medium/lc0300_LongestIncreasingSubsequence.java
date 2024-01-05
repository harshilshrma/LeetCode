// Date: 5 January 2024
// Given an integer array nums, return the length of the longest strictly increasing
// subsequence
// A subsequence is an array that can be derived from another array by deleting some or no elements without
// changing the order of the remaining elements.

package Medium;

public class lc0300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length]; // Store the tails of the increasing subsequences
        int len = 0; // Initialize the length of the longest increasing subsequence

        for (int n : nums) { // Iterate through each number in the given array
            int left = 0, right = len; // Initialize left and right pointers for binary search

            while (left < right) { // Perform binary search to find the insertion position for the current number
                int mid = left + (right - left) / 2; // Calculate mid index

                // If current tail value is less than the number, adjust the left pointer
                if (tails[mid] < n) {
                    left = mid + 1;
                } else { // If current tail value is greater or equal, adjust the right pointer
                    right = mid;
                }
            }

            tails[left] = n; // Insert the number at the determined position

            if (left == len) { // If the current position is at the end, increment the length of the LIS
                len++;
            }
        }
        return len; // Return the length of the longest increasing subsequence
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0300_LongestIncreasingSubsequence obj = new lc0300_LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(obj.lengthOfLIS(nums));
    }
}
