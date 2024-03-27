// 27 March 2024
// Given an array of integers nums and an integer k, return the number of contiguous subarrays where
// the product of all the elements in the subarray is strictly less than k.

package Medium;

public class lc0713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod = prod * nums[j];
                if (prod < k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, count = 0, prod = 1;

        if (k <= 1) {
            return 0;
        }

        while (j < n) {
            prod *= nums[j];

            while (prod >= k) {
                prod /= nums[i];
                i++;
            }


            count += j - i + 1;
            j++;
        }
        return count;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0713_SubarrayProductLessThanK obj = new lc0713_SubarrayProductLessThanK();
        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        System.out.println(obj.numSubarrayProductLessThanK(nums, k));
        System.out.println(obj.numSubarrayProductLessThanK1(nums, k));
    }
}
