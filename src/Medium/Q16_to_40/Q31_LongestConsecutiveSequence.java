// Date: July 06, 2023
// Q30: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

package Medium.Q16_to_40;

import java.util.HashSet;

public class Q31_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int a = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        for (int n : nums) {
            if (!set.contains(n-1)) {
                int count = 1;
                while (set.contains(n+1)) {
                    n++;
                    count++;
                };
                a = Math.max(count, a);
            }
        }
        return a;
    }

    // Main function for testing
    public static void main(String[] args) {
        Q31_LongestConsecutiveSequence obj1 = new Q31_LongestConsecutiveSequence();
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(obj1.longestConsecutive(arr1));
        System.out.println(obj1.longestConsecutive(arr2));
    }
}
