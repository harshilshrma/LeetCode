// 21-05-2024 - 08:14 pm
// Given an integer array nums of unique elements, return all possible
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.

package Medium;

import java.util.ArrayList;
import java.util.List;

public class lc0078_Subsets {
    // Functions
    private final List<List<Integer>> res = new ArrayList<>();

    public void solve(int[] nums, int i, List<Integer> temp) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]); // take
        solve(nums, i + 1, temp);

        temp.remove(temp.size() - 1); // not take
        solve(nums, i + 1, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return res;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0078_Subsets obj = new lc0078_Subsets();
        System.out.println(obj.subsets(new int[]{1, 2, 3}));
    }
}



