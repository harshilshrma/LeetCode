// Date: 20 March 2024
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

package Easy;

public class lc0485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Initialize the maximum count of consecutive ones to the minimum value of integer
        int maxCount = Integer.MIN_VALUE;
        // Initialize the count of consecutive ones
        int count = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is 1, increment the count of consecutive ones and update maxCount if necessary
            if (nums[i] != 0) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                // If the current element is 0, reset the count of consecutive ones
                count = 0;
            }
        }
        // Return the maximum count of consecutive ones
        return Math.max(count, maxCount);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0485_MaxConsecutiveOnes obj = new lc0485_MaxConsecutiveOnes();
        int[] nums = {0};
        System.out.println(obj.findMaxConsecutiveOnes(nums));
    }
}
