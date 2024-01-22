// Date: 22 January 2024
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to
// some error, one of the numbers in s got duplicated to another number in the set, which results in repetition
// of one number and loss of another number.
//You are given an integer array nums representing the data status of this set after the error.
//Find the number that occurs twice and the number that is missing and return them in the form of an array.

package Easy;
import java.util.Arrays;

public class lc0645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        int missing = 0, duplicate = 0;

        // Count frequency of each element in the array
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        // Identify the duplicate and missing elements
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                duplicate = i;
            }
            if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[] {duplicate, missing};
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0645_SetMismatch obj = new lc0645_SetMismatch();
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(obj.findErrorNums(nums)));

    }
}
