// Date: 08 December 2023
// Q35: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> finalResult = new LinkedList<List<Integer>>();

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2; i++){
            // Only considering non-duplicate elements for i
            if (i == 0 || nums[i] != nums[i - 1]){
                int target = -nums[i];  // nums[i] + nums[left] + nums[right] = 0
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right){
                    if(nums[left] + nums[right] == target) {
                        ArrayList<Integer> preResult = new ArrayList<>();
                        preResult.add(nums[i]);
                        preResult.add(nums[left]);
                        preResult.add(nums[right]);
                        finalResult.add(preResult);
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        lc0015_3Sum obj = new lc0015_3Sum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSum(arr));
    }
}
