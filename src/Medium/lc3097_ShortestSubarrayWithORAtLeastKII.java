// 30 March 2024
// You are given an array nums of non-negative integers and an integer k.
//
//An array is called special if the bitwise OR of all of its elements is at least k.
//
//Return the length of the shortest special non-empty
//subarray
// of nums, or return -1 if no special subarray exists.

package Medium;

public class lc3097_ShortestSubarrayWithORAtLeastKII {
    public int minimumSubarrayLength(int[] nums, int k) {
        // Initialize an array to store the count of each bit position
        int[] cnt = new int[30];
        // Initialize pointers and the answer variable
        int p = 0, ans = Integer.MAX_VALUE;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Update the count array for each bit position using bitwise operations
            for (int j = 0; j < 30; j++) {
                cnt[j] += (nums[i] >> j) & 1;
            }

            // Check if the current subarray satisfies the condition
            while (p <= i && val(cnt) >= k) {
                // Update the answer with the minimum subarray length
                ans = Math.min(ans, i - p + 1);
                // Update the count array for the subarray starting at pointer p
                for (int j = 0; j < 30; j++) {
                    cnt[j] -= (nums[p] >> j) & 1;
                }
                // Move the start pointer forward
                p++;
            }
        }

        // If ans is still Integer.MAX_VALUE, return -1; otherwise, return the minimum subarray length
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // Helper method to calculate the bitwise XOR value of the count array
    public int val(int[] cnt) {
        int a = 0;
        // Calculate the bitwise XOR value for each bit position
        for (int i = 0; i < 30; i++) {
            if (cnt[i] != 0) {
                a ^= 1 << i;
            }
        }
        return a;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc3097_ShortestSubarrayWithORAtLeastKII obj = new lc3097_ShortestSubarrayWithORAtLeastKII();
        int[] nums = {1, 2, 3};
        int k = 2;
        System.out.println(obj.minimumSubarrayLength(nums, k));
    }
}
