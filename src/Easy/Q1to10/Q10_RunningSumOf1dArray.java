// Date: 03 March 2023
// Q10: Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
// Return the running sum of nums.

package Easy.Q1to10;
public class Q10_RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int n= nums.length;
        int[] runningSum = new int[n];
        int total=0;  //Initializing a variable

        // Now, we can understand it step by step:
        // For example, Array = [1,2,3,4]
        // Now,
        //      i=0: total = 0 + nums[0] = 0+1 = 1 --> runningSum[0]
        //      i=1: total = 1 + nums[1] = 1+2 = 3 --> runningSum[1]
        //      i=2: total = 3 + nums[2] = 3+3 = 6 --> runningSum[2]
        //      i=3: total = 6 + nums[3] = 6+4 = 10 --> runningSum[3]
        // Thus, the code will be as follows:
        for (int i=0; i<n; i++){
            total = total + nums[i];
            runningSum[i] = total;
        }
        return runningSum;
    }
}

