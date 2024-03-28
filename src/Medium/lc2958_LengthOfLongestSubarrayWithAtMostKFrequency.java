// 29 March 2024
// You are given an integer array nums and an integer k.

//The frequency of an element x is the number of times it occurs in an array.

//An array is called good if the frequency of each element in this array is less than or equal to k.
//Return the length of the longest good subarray of nums.
//A subarray is a contiguous non-empty sequence of elements within an array.

package Medium;

import java.util.HashMap;

public class lc2958_LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0, n = nums.length;
        // Create a HashMap to store the frequency of each integer
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array to find subarrays with at most k distinct integers
        for (int i = 0; i < n; i++) {
            // Nested loop to consider all subarrays starting from index i
            for (int j = i; j < n; j++) {
                // Update the frequency of the current integer in the subarray
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                // If the number of distinct integers in the subarray is at most k, update maxLen
                if (map.get(nums[j]) <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    // If the number of distinct integers exceeds k, break the inner loop
                    break;
                }
            }
            // Clear the HashMap for the next iteration of the outer loop
            map.clear();
        }

        // Return the maximum subarray length found
        return maxLen;
    }

    // Sliding window approach
    public int maxSubarrayLength1(int[] nums, int k) {
        int maxLen = 0, n = nums.length, i = 0, j = 0;
        // Create a HashMap to store the frequency of each integer within the sliding window
        HashMap<Integer, Integer> map = new HashMap<>();

        // Use a sliding window to find subarrays with at most k distinct integers
        while (j < n) {
            // Update the frequency of the current integer in the sliding window
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Shrink the sliding window if the number of distinct integers exceeds k
            while (i < j && map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            // Update maxLen with the length of the current valid subarray
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        // Return the maximum subarray length found
        return maxLen;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2958_LengthOfLongestSubarrayWithAtMostKFrequency obj = new lc2958_LengthOfLongestSubarrayWithAtMostKFrequency();
        int[] nums = {2, 2, 3};
        int k = 1;
        System.out.println(obj.maxSubarrayLength(nums, k));
        System.out.println(obj.maxSubarrayLength1(nums, k));
    }


}
