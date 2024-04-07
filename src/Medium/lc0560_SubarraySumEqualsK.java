// Date: 28 January 2024
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

package Medium;

import java.util.HashMap;

public class lc0560_SubarraySumEqualsK {

    public int subarraySumBRUTE(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            int sum = 0;

            // Consider all subarrays starting from index i
            for (int j = i; j < n; j++) {
                // Calculate the sum of the current subarray
                sum += nums[j];

                // If the sum equals k, increment the count
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySumOPTIMAL(int[] nums, int k) {
        // Create a HashMap to store prefix sums and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, prefixSum = 0;

        // Initialize the prefix sum and add it to the map with frequency 1
        // (to handle subarrays starting from index 0)
        map.put(0, 1);

        // Iterate through each element of the array
        for (int i = 0; i < nums.length; i++) {
            // Update the prefix sum
            prefixSum += nums[i];

            // Calculate the complement value to find subarrays with sum k
            int toRemove = prefixSum - k;

            // If the complement value exists in the map, increment the count by its frequency
            if (map.containsKey(toRemove)) {
                count += map.get(toRemove);
            }

            // Update the map with the current prefix sum and its frequency
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0560_SubarraySumEqualsK obj = new lc0560_SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(obj.subarraySumBRUTE(nums, k));
        System.out.println(obj.subarraySumOPTIMAL(nums, k));
    }
}
