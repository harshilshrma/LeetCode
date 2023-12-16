// Date: 22 March 2023
// Q20: Given an array nums of integers, return how many of them contain an even number of digits.


package Easy;
public class lc1295_FindNosWithEvenNosOfDigit {
    public int findNumbers(int[] nums){
        int sum=0, count=0;
        for (int i=0; i<nums.length; i++){
            count = 0;
            while (nums[i] != 0) {
                nums[i] /= 10;
                count += 1;
            }
            if (count % 2 == 0) sum += 1;
        }
        return sum;
    }
}

