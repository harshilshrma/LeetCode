// 29 March 2024
// You are given an integer array nums and a positive integer k.
//
//Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
//
//A subarray is a contiguous sequence of elements within an array.

package Medium;

public class lc2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        // Find the maximum element in the array
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int count = 0, i = 0, j = 0;
        long subArrCount = 0;

        // Use a sliding window approach to count subarrays
        while (j < n) {
            // If the current element is the maximum element, increment count
            if (nums[j] == max) {
                count++;
            }

            // Shrink the window if count exceeds or equals k
            while (count >= k) {
                // Increment subArrCount by the number of subarrays ending at index j
                subArrCount += n - j;

                // If the element at the start of the window is the maximum element, decrement count
                if (nums[i] == max) {
                    count--;
                }
                // Move the window's start pointer forward
                i++;
            }

            // Move the window's end pointer forward
            j++;
        }

        // Return the total count of subarrays
        return subArrCount;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes obj = new lc2962_CountSubarraysWhereMaxElementAppearsAtLeastKTimes();
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        System.out.println(obj.countSubarrays(nums, k));
    }
}
