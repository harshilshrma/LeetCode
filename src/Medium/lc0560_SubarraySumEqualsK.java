// Date: 28 January 2024
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

package Medium;

import java.util.HashMap;

public class lc0560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store cumulative sums and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int cumSum = 0;
        map.put(0, 1); // Initialize with a cumulative sum of 0 and frequency of 1

        // Iteration through the array
        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];

            // Check if the complement of the current cumulative sum exists in the HashMap
            if (map.containsKey(cumSum - k)) {
                // Increment the result by the frequency of the complement
                result += map.get(cumSum - k);
            }

            // Update the HashMap with the current cumulative sum and its frequency
            map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
        }

        // Return the final result
        return result;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0560_SubarraySumEqualsK obj = new lc0560_SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(obj.subarraySum(nums, k));
    }
}
