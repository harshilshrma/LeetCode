// Date: 03 March 2023
// Q9: Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
// answer.length == nums.length.
// answer[i] = |leftSum[i] - rightSum[i]|.
// Where:
// leftSum[i] is the sum of elements to the left of the index i in the array nums.
//      If there is no such element, leftSum[i] = 0.
// rightSum[i] is the sum of elements to the right of the index i in the array nums.
//      If there is no such element, rightSum[i] = 0.
// Return the array answer.

// My Solution: 32ms Runtime
package Easy.Q1to10;
public class Q9_LeftAndRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int total;

        leftSum[0] = 0;
        for (int i=1; i<nums.length; i++){
            total=0;
            for (int j=0; j<i; j++){
                leftSum[i] = total+nums[j];
                total = leftSum[i];
            }
        }

        rightSum[nums.length-1] = 0;
        for (int i=0; i<nums.length-1; i++){
            total=0;
            for (int j=i+1; j<nums.length; j++){
                rightSum[i] = total+nums[j];
                total = rightSum[i];
            }
        }

        for (int i=0; i<nums.length; i++){
            answer[i] = (leftSum[i]-rightSum[i]);
            if (answer[i]<0){
                answer[i] = -answer[i];
            }
        }
        return answer;
    }
}

// Better Solution: 1ms Runtime
class abc {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int [] right = new int[n];
        int [] left =  new int[n];
        int [] ans = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=nums[i];
            left[i]=sum;
        }
        sum = 0;
        for(int i = n-1; i >=0; i--){
            sum+=nums[i];
            right[i]=sum;
        }

        for(int i = 1; i < n-1; i++){
            ans[i] = Math.abs(right[i+1] - left[i-1]);
        }
        if(n > 1)
            ans[n-1] = left[n-2];
        if(n > 1) ans[0] = right[1];
        return ans;
    }
}
