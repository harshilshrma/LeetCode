// Date: 2 March 2024
// Given an integer array nums sorted in non-decreasing order, return an array of the squares
// of each number sorted in non-decreasing order.

package Easy;

import java.util.Arrays;

public class lc0977_SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int idx = 0;
        for (int i : nums) {
            nums[idx] = nums[idx] * nums[idx];
            idx++;
        }

        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        lc0977_SquaresOfASortedArray obj = new lc0977_SquaresOfASortedArray();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(obj.sortedSquares(nums)));
    }
}
