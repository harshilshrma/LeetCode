// Date: 03 March 2023
// Q11: Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
// That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
// Return the answer in an array.

// My Solution: 17ms
package Easy.Q11to20;
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
        for(int i=0; i<nums.length; i++)
            cnt[nums[i]]++;    // will store the frequency of occurence of each value.
        for(int i=1; i<101; i++)
            cnt[i] += cnt[i-1];  // at index i, it will give how many values are smaller than cnt[i]
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==0)
                ans[i]=0;
            else
                ans[i] = cnt[nums[i]-1];
        }
        return ans;
    }
}

