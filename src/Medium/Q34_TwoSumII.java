// Q34: Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
// and numbers[index2] where 1 <= index1 < index2 < numbers.length.
// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of
// length 2. The tests are generated such that there is exactly one solution. You may not use the same element twice.
// Your solution must use only constant extra space.

package Medium;

import java.util.Arrays;

public class Q34_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // Since the array is already sorted, we will just check through the array with 2 pointers
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l+1, r+1};
            } else if (sum <= target) {
                l++;
            }
            else {
                r--;
            }
        }
        return new int[]{0};
    }

    // Main function for testing
    public static void main(String[] args) {
        Q34_TwoSumII obj = new Q34_TwoSumII();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(obj.twoSum(arr, target)));
    }
}
