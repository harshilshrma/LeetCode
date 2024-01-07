// Date: 7 January 2024
// Given an integer array nums, return the number of all the arithmetic subsequences of nums.
//A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference
// between any two consecutive elements is the same.
//For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
//For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
//A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
//For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
//The test cases are generated so that the answer fits in 32-bit integer.

package Hard;

import java.util.Arrays;
import java.util.HashMap;

public class lc0446_ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        HashMap<Long, Integer>[] mp = new HashMap[n]; // Array of HashMaps to store differences and counts

        for (int i = 0; i < n; i++) {
            // Initializing a HashMap for each index 'i' to store differences and their counts
            mp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                // Calculating the difference between the elements at indices 'i' and 'j'
                long diff = (long) nums[i] - nums[j];

                // Retrieving the count of subsequences with the same difference
                int count = mp[j].getOrDefault(diff, 0);

                // Accumulating the counts for valid arithmetic subsequences
                result = result + count;

                // Updating the count for subsequences ending at index 'i' with the same difference
                mp[i].put(diff, mp[i].getOrDefault(diff, 0) + count + 1);
            }
        }
        return result; // Returning the total count of valid arithmetic subsequences
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0446_ArithmeticSlicesIISubsequence obj = new lc0446_ArithmeticSlicesIISubsequence();
        int[] nums = {2,4,6,8,10};
        System.out.println(obj.numberOfArithmeticSlices(nums));
    }
}