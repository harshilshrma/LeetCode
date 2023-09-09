// Date: 09 September 2023
// Q35: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q35_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        return new ArrayList<List<Integer>>();
    }

    public static void main(String[] args) {
        Q35_3Sum obj = new Q35_3Sum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSum(arr));
    }
}
