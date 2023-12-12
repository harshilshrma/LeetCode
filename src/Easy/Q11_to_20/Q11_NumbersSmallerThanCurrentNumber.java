// Date: 03 March 2023
// Q11: Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
// That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
// Return the answer in an array.

package Easy.Q11_to_20;

// My Solution: 17ms
public class Q11_NumbersSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int total;
        for (int i=0; i<nums.length; i++){
            total=0;
            for (int j=0; j<nums.length; j++){
                if (j!=i){
                    if (nums[i]>nums[j]) total++;
                }
            }
            ans[i] = total;
        }
        return ans;
    }
}

// Other Solution: 1ms
class abcd {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] cnt = new int[101];  // based on the range of value stored in nums array.
        for(int i=0; i<nums.length; i++) cnt[nums[i]]++; // will store the frequency of occurence of each value.
        for(int i=1; i<101; i++) cnt[i] += cnt[i-1]; //This is cumulative sum
        // at index i, it will give how many values are smaller than cnt[i]
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0)
                ans[i]=0;
            else
                ans[i] = cnt[nums[i]-1];
        }
        return ans;
    }
}

/* Detailed Explanation
nums = [8, 1, 2, 2, 3]
Explanation:
Initialize two arrays, ans and cnt. ans will store the final result, and cnt is an array used to count the frequency of
each value in the input array. The cnt array has a size of 101, which is given in the question.

Loop through the input array nums and update the cnt array to count the frequency of each value.
In this example:
cnt[1] becomes 1 because there's one occurrence of the value 1.
cnt[2] becomes 2 because there are two occurrences of the value 2.
cnt[3] becomes 1 because there's one occurrence of the value 3.
cnt[8] becomes 1 because there's one occurrence of the value 8.

Calculate cumulative counts in the cnt array. This step makes each element at index i represent the count of elements
smaller than or equal to i. So, after this step, cnt will look like this:
cnt[0] = 0
cnt[1] = 1
cnt[2] = 3
cnt[3] = 4
cnt[4] = 4 (since no value in nums is 4, cnt[4] remains the same)

Finally, loop through the input array nums again and calculate the values to be stored in the ans array.
For each element at index i, you check its value nums[i], and if it's 0, you set ans[i]
to 0 (since there are no smaller values).
Otherwise, you set ans[i] to cnt[nums[i] - 1], which gives the count of smaller values.

ans[0] = cnt[7] = 4
ans[1] = cnt[0] = 0
ans[2] = cnt[1] = 1
ans[3] = cnt[1] = 1
ans[4] = cnt[2] = 3

Output:
ans = [4, 0, 1, 1, 3]
*/
