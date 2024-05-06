// 6 May 2024
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.

package Medium;

import java.util.Arrays;

public class lc0034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1, last = -1;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    // Main function  for testing
    public static void main(String[] args) {
        lc0034_FindFirstAndLastPositionOfElementInSortedArray obj = new lc0034_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }
}
