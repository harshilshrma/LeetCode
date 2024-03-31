// 31 March 2024
// You are given an integer array nums and two integers minK and maxK.
//
//A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
//
//The minimum value in the subarray is equal to minK.
//The maximum value in the subarray is equal to maxK.
//Return the number of fixed-bound subarrays.
//
//A subarray is a contiguous part of an array.

package Hard;

public class lc2444_CountSubarraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minkPos = -1, maxkPos = -1, culpritIdx = -1;
        long count = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update the index of the last element that violates the range condition
            if (nums[i] > maxK || nums[i] < minK) {
                culpritIdx = i;
            }

            // Update the index of the last occurrence of minK and maxK in the array
            if (nums[i] == minK) {
                minkPos = i;
            }
            if (nums[i] == maxK) {
                maxkPos = i;
            }

            // Calculate the smaller index among minkPos and maxkPos
            long smallerIdx = Math.min(minkPos, maxkPos);

            // Calculate the number of subarrays with maximum element within the range [minK, maxK]
            long temp = smallerIdx - culpritIdx;

            // Add the count of valid subarrays to the total count
            count += (temp <= 0) ? 0 : temp;
        }

        // Return the total count of valid subarrays
        return count;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2444_CountSubarraysWithFixedBounds obj = new lc2444_CountSubarraysWithFixedBounds();
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1, maxK = 5;
        System.out.println(obj.countSubarrays(nums, minK, maxK));
    }
}
