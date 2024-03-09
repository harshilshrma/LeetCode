// Date: 09 March 2024
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

package Medium;

import java.util.Arrays;

public class lc0189_RotateArray {

    public void reverse (int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
        return nums;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0189_RotateArray obj = new lc0189_RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(obj.rotate(nums, k)));
    }
}
