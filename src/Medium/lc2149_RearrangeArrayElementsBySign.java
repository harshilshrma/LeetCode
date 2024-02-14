// Date: 14 February 2024
// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and
// negative integers.

//You should rearrange the elements of nums such that the modified array follows the given conditions:

//Every consecutive pair of integers have opposite signs.
//For all integers with the same sign, the order in which they were present in nums is preserved.
//The rearranged array begins with a positive integer.
//Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

package Medium;

import java.util.Arrays;

public class lc2149_RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        // Initialize a new array to store the rearranged elements
        int[] result = new int[nums.length];

        // Initialize pointers to track positions for positive and negative integers
        int pos = 0;
        int neg = 1;

        // Iterate through each element in the input array
        for (int num : nums) {
            // If the current element is positive, place it at even index and update pos
            if (num > 0) {
                result[pos] = num;
                pos += 2;
            } else { // If the current element is negative, place it at odd index and update neg
                result[neg] = num;
                neg += 2;
            }
        }
        return result; // Return the rearranged array
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2149_RearrangeArrayElementsBySign obj = new lc2149_RearrangeArrayElementsBySign();
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] nums1 = {-1, 1};
        System.out.println(Arrays.toString(obj.rearrangeArray(nums)));
        System.out.println(Arrays.toString(obj.rearrangeArray(nums1)));

    }
}
