// Date: 20 March 2024
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.

package Easy;

public class lc0136_SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0136_SingleNumber obj = new lc0136_SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(obj.singleNumber(nums));
    }
}
