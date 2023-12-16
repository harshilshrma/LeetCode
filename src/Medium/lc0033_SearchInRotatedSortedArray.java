// Date: 14 December 2023
// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index
// k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
// nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and
// become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in
// nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

package Medium;

public class lc0033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }

            // left sorted portion
            if (nums[m] >= nums[l]) { // This means our middle value belongs to the left sorted portion
                if (target > nums[m] || target < nums[l]) {
                    // This means our target value will not be present in this left part but will be in the right part
                    l = m + 1;
                } else {
                    // This means that target is less than the middle but greater than the left, we search the left part
                    r = m - 1;
                }
            }

            // right sorted portion
            else {
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    // Opposite of if condition
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        lc0033_SearchInRotatedSortedArray obj = new lc0033_SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(obj.search(nums, target));
    }
}
