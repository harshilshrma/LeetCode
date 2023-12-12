// Date: 12 December 2023
// Given an array of integers nums which is sorted in ascending order, and an integer target,
// write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
// You must write an algorithm with O(log n) runtime complexity.

package Easy.Q31_to_40;

public class Q38_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q38_BinarySearch obj = new Q38_BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        System.out.println(obj.search(nums, target));

    }
}
