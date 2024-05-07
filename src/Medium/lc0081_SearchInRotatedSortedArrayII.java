// 7 May 2024
// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
//
//Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
//
//Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
//
//You must decrease the overall operation steps as much as possible.

package Medium;

public class lc0081_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if found at mid
            if (nums[mid] == target) return true;

            // if all pointers are equal
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // right sorted array
            if (nums[mid] <= nums[high]) {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else { // left sorted array
                if (nums[mid] >= target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0081_SearchInRotatedSortedArrayII obj = new lc0081_SearchInRotatedSortedArrayII();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(obj.search(nums, target));
    }
}
