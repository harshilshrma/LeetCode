// Date: 13 December 2023
// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
// the array nums = [0,1,2,4,5,6,7] might become:
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1],
// a[2], ..., a[n-2]].
// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// You must write an algorithm that runs in O(log n) time.

package Medium;

public class Q41_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int res = nums[0]; // Setting any random value
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            // If the array is already sorted
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = (l + r) / 2;
            // Updating the minimum value by comparing with the middle value
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q41_FindMinimumInRotatedSortedArray obj = new Q41_FindMinimumInRotatedSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(obj.findMin(nums));
    }
}
