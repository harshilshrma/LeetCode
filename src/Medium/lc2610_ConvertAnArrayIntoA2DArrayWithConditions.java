// dATE: 2 January 2024
// You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
//The 2D array should contain only the elements of the array nums.
//Each row in the 2D array contains distinct integers.
//The number of rows in the 2D array should be minimal.
//Return the resulting array. If there are multiple answers, return any of them.
//Note that the 2D array can have a different number of elements on each row.

package Medium;

import java.util.ArrayList;
import java.util.List;

public class lc2610_ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length + 1];
        ArrayList<List<Integer>> ans = new ArrayList<>();

        for (int i : nums) {
            if (freq[i] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[i]).add(i);
            freq[i]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        lc2610_ConvertAnArrayIntoA2DArrayWithConditions obj = new lc2610_ConvertAnArrayIntoA2DArrayWithConditions();
        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(obj.findMatrix(nums));
    }

}
