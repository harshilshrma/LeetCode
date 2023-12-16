// Date: 03 March 2023
// Q13: Given an array of integers nums, return the number of good pairs.
// A pair (i, j) is called good if nums[i] == nums[j] and i < j.

package Easy;
public class lc1512_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<nums.length; j++){
                if(i<j && nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

