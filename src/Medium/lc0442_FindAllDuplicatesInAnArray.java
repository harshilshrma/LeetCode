// Date: 25 March 2024
// Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears once or twice, return an array of all the integers that appears twice.
//You must write an algorithm that runs in O(n) time and uses only constant extra space.

package Medium;

import java.util.ArrayList;
import java.util.List;

public class lc0442_FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        // Initialize a list to store the duplicates
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Get the absolute value of the current number
            int num = Math.abs(nums[i]);

            // Calculate the index corresponding to the current number
            int idx = num - 1;

            // If the number at the calculated index is negative, it means it has appeared before,
            // so add it to the list of duplicates
            if (nums[idx] < 0) {
                ans.add(num);
            }
            // Otherwise, mark the number at the calculated index as negative to indicate its presence
            else {
                nums[idx] = -nums[idx];
            }
        }

        // Return the list of duplicates
        return ans;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0442_FindAllDuplicatesInAnArray obj = new lc0442_FindAllDuplicatesInAnArray();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(obj.findDuplicates(nums));
    }
}
