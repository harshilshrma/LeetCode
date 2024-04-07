// 7 April 2024
// You are given an array of integers nums. Return the length of the longest subarray of nums which is either
//strictly increasing or strictly decreasing

package Easy;

public class lc3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                incLength++;
                decLength = 1;
            } else if(nums[i] < nums[i - 1]) {
                decLength++;
                incLength = 1;
            } else {
                incLength = 1;
                decLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray obj = new lc3105_LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();
        int[] nums = {1,4,3,3,2};
        System.out.println(obj.longestMonotonicSubarray(nums));
    }
}
