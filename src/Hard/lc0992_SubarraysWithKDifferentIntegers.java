// 30 March 2024
// Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//A good array is an array where the number of different integers in that array is exactly k.
//
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.

package Hard;

import java.util.HashMap;
import java.util.HashSet;

public class lc0992_SubarraysWithKDifferentIntegers {

    // Brute Force
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length, count = 0;
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array to consider all possible subarrays
        for (int i = 0; i < n; i++) {
            // Nested loop to consider subarrays starting from index i
            for (int j = i; j < n; j++) {
                set.add(nums[j]);

                // If the number of distinct elements in the subarray equals k, increment count
                if (set.size() == k) {
                    count++;
                }
            }
            // Clear the set for the next iteration
            set.clear();
        }
        // Return the total count of subarrays with exactly k distinct elements
        return count;
    }

    // Sliding window
    public int subarraysWithKDistinct1(int[] nums, int k) {
        // The count of subarrays with exactly k distinct elements is equal to the count of subarrays
        // with at most k distinct elements minus the count of subarrays with at most (k-1) distinct elements
        return solve(nums, k) - solve(nums, k - 1);
    }

    // Helper method to count the number of subarrays with at most k distinct elements using sliding window
    public int solve(int[] nums, int k) {
        int n = nums.length, count = 0, i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Use a sliding window to consider all possible subarrays
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Shrink the window if the number of distinct elements exceeds k
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            // Increment count by the number of subarrays ending at index j
            count += j - i + 1;
            j++;
        }
        // Return the total count of subarrays with at most k distinct elements
        return count;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0992_SubarraysWithKDifferentIntegers obj = new lc0992_SubarraysWithKDifferentIntegers();
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(obj.subarraysWithKDistinct(nums, k));
        System.out.println(obj.subarraysWithKDistinct1(nums, k));
    }
}
