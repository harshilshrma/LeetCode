// Date: 12 March 2024
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.

package Easy;

import java.util.Arrays;

public class lc0283_MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;

        // finding first 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // if no 0 found
        if (j == -1) return nums;

        // shifting
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0283_MoveZeroes obj = new lc0283_MoveZeroes();
        int[] nums = {1, 1, 0, 3, 12};
        System.out.println(Arrays.toString(obj.moveZeroes(nums)));
    }
}
