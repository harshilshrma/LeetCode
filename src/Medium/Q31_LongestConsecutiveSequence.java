// Date: July 06, 2023
// Q30: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

package Medium;

public class Q31_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {



        return 8;
    }

    public static void main(String[] args) {
        Q31_LongestConsecutiveSequence obj1 = new Q31_LongestConsecutiveSequence();
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(obj1.longestConsecutive(arr1));
        System.out.println(obj1.longestConsecutive(arr2));
    }
}
