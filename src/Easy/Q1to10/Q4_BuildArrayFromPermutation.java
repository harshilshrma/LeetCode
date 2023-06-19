// Date: 28 February 2023

// Note: Q3 was of SQL Language, so it has not been added.

// Q4: Given a zero-based permutation nums (0-indexed), build an array ans of the same length
// where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
// A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).


// My Solution - O(n)
package Easy.Q1to10;
public class Q4_BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0; i< nums.length; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}

// Other Solution with O(1) complexity
class Solution {
    public int[] buildArray(int[] nums) {
        suff(nums,0);
        return nums;
    }
    public void suff(int[] nums, int i) {
        if(i < nums.length) {
            int r = nums[i];
            int res = nums[r];
            suff(nums, i + 1);
            nums[i] = res;
        }
    }
}