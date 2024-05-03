// 2 May 2024
// Given an integer array nums, find a
//subarray
// that has the largest product, and return the product.
//
//The test cases are generated so that the answer will fit in a 32-bit integer.

package Medium;

public class lc0152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1, n = nums.length, ans = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0152_MaximumProductSubarray obj = new lc0152_MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(obj.maxProduct(nums));
    }
}
