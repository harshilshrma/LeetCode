// Date: 22 March 2023
// Q21: You are given a positive integer array nums.
// The element sum is the sum of all the elements in nums.
// The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
// Return the absolute difference between the element sum and digit sum of nums.
// Note that the absolute difference between two integers x and y is defined as |x - y|.


package Easy;
public class lc2535_DiffBwElementSumNDigitSumofArray {
    public int differenceOfSum(int[] nums) {
        int elesum=0, digsum=0, a, rem;

        for (int i=0; i<nums.length; i++){
            elesum = elesum + nums[i];
            if (nums[i]<10) digsum = digsum + nums[i];
            if (nums[i]>=10){
                while (nums[i] != 0) {
                    rem = nums[i] % 10;
                    digsum = digsum + rem;
                    nums[i] /= 10;
                }
            }
        }
        a = elesum - digsum;
        if (a<0) a = -a;
        return a;
    }
}

