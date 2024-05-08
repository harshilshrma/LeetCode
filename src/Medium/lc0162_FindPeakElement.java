// 8 may 2024
// A peak element is an element that is strictly greater than its neighbors.
//
//Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains
// multiple peaks, return the index to any of the peaks.
//
//You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
// greater than a neighbor that is outside the array.
//
//You must write an algorithm that runs in O(log n) time.

package Medium;

public class lc0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0162_FindPeakElement obj = new lc0162_FindPeakElement();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(obj.findPeakElement(nums));
    }

}
