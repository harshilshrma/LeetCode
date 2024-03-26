// 26 March 2024
// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

package Hard;

public class lc0041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // Get the length of the array
        int n = nums.length;
        // Initialize a boolean variable to track if the array contains 1
        boolean contains1 = false;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Check if the current element is 1
            if (nums[i] == 1) {
                contains1 = true;
            }
            // If the current element is non-positive or greater than the length of the array, replace it with 1
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // If the array does not contain 1, return 1
        if (!contains1) {
            return 1;
        }

        // Mark the presence of positive integers by making the corresponding index negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            int idx = num - 1;

            if (nums[idx] < 0) continue;

            nums[idx] = -nums[idx];
        }

        // Find the first missing positive integer in the modified array
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0041_FirstMissingPositive obj = new lc0041_FirstMissingPositive();
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(obj.firstMissingPositive(nums));
    }
}
