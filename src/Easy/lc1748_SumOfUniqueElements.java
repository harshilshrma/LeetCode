// Date: 08 March 2023
// Q18: You are given an integer array nums. The unique elements of an array are the elements that appear
// exactly once in the array. Return the sum of all the unique elements of nums.

package Easy;
public class lc1748_SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        int sum = 0, count = 0;
        int[] abc = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] != nums[j]) {
                    count = count + 1;
                }
            }
            if (count == nums.length - 1) sum = sum + nums[i];
        }
        return sum;
    }
}

