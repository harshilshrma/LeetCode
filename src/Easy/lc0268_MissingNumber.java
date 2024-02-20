// Date: 20 February 2024
// Given an array nums containing n distinct numbers in the range [0, n], return the only
// number in the range that is missing from the array.

package Easy;

public class lc0268_MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Calculate total sum of numbers from 0 to n

        int total = (n * (n + 1)) / 2;
        int sum = 0;

        // Calculate sum of all numbers present in the array
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // Return the difference between total sum and sum of array elements
        return total - sum;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0268_MissingNumber obj = new lc0268_MissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(obj.missingNumber(nums));
    }
}
