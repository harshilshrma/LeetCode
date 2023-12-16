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
package Easy;

// My solution: 32ms
public class lc2574_LeftAndRightSumDifferences {
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

// Better Solution: 2ms Runtime
class abc {
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        // Calculate leftSum for each index
        int sum = 0;
        for (int i = 0; i < n; i++) {
            leftSum[i] = sum;
            sum += nums[i];
        }

        // Calculate rightSum for each index
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = sum;
            sum += nums[i];
        }

        // Calculate the absolute difference for each index
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return result;
    }
}