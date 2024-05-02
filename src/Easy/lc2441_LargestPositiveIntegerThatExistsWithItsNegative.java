// 2 May 2024
// Given an integer array nums that does not contain any zeros, find the largest positive integer k such
// that -k also exists in the array.
//
//Return the positive integer k. If there is no such integer, return -1.

package Easy;

import java.util.HashSet;

public class lc2441_LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i : nums) {
            int rem = -i;
            if (set.contains(rem)) {
                ans = Math.max(ans, Math.abs(rem));
            }
        }

        return ans == 0 ? -1 : ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2441_LargestPositiveIntegerThatExistsWithItsNegative obj = new lc2441_LargestPositiveIntegerThatExistsWithItsNegative();
        int[] nums = {-1, 2, -3, 3};
        System.out.println(obj.findMaxK(nums));
    }
}
