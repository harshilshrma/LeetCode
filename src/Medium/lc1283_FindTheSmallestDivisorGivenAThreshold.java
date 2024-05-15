// 15-05-2024 - 01:39 pm
// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
// divide all the array by it, and sum the division's result. Find the smallest divisor such that the result
// mentioned above is less than or equal to threshold.
//
//Each result of the division is rounded to the nearest integer greater than or equal to that element.
// (For example: 7/3 = 3 and 10/2 = 5).
//
//The test cases are generated so that there will be an answer.

package Medium;

import java.util.Arrays;

public class lc1283_FindTheSmallestDivisorGivenAThreshold {
    // Functions
    public static int calculate(int[] nums, int n) {
        int ans = 0;
        for (int i : nums) {
            ans = ans + Math.ceilDiv(i, n);
        }
        return ans;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = 0, ans = -1, n = nums.length;
        if (n > threshold) return -1;

        for (int i : nums) {
            maxi = Math.max(maxi, i);
        }

        Arrays.sort(nums);
        int low = 1, high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (calculate(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1283_FindTheSmallestDivisorGivenAThreshold obj = new lc1283_FindTheSmallestDivisorGivenAThreshold();
        int[] nums = {1, 2, 5, 9};
        int[] nums1 = {44, 22, 33, 11, 1};
        int[] nums2 = {21212, 10101, 12121};
        System.out.println(obj.smallestDivisor(nums, 6));
        System.out.println(obj.smallestDivisor(nums1, 5));
        System.out.println(obj.smallestDivisor(nums2, 1000000));
    }
}



