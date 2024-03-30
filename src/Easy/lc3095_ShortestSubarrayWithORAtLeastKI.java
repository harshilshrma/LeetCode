// 30 March 2024
// You are given an array nums of non-negative integers and an integer k.
//
//An array is called special if the bitwise OR of all of its elements is at least k.
//
//Return the length of the shortest special non-empty
//subarray
// of nums, or return -1 if no special subarray exists.

package Easy;

public class lc3095_ShortestSubarrayWithORAtLeastKI {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int val = 0, len = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            val = 0;
            for (int j = i; j < n; j++) {
                val |= nums[j];
                if (val >= k) {
                    len = Math.min(len, j - i + 1);
                    break;
                }
            }
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc3095_ShortestSubarrayWithORAtLeastKI obj = new lc3095_ShortestSubarrayWithORAtLeastKI();
        int[] nums = {1, 2, 3};
        int k = 2;
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }
}
