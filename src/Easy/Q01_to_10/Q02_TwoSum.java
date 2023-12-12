// Date: 26 February 2023
// Q02: Given an array of integers nums and an integer target, return indices of the two numbers such that
// they add up to target. You may assume that each input would have exactly one solution, and you may not use
// the same element twice. You can return the answer in any order.

package Easy.Q01_to_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q02_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();   //Creating a HashMap with the name 'map'.
        for (int i=0; i <nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)) {        //Checking for the remaining value, if it is present in the map alr
                return new int[] { map.get(diff), i};
            }
            map.put(nums[i], i);  //In this HashMap, the key is an element of nums and the value is its index.
        }
        return null;
    }

    public static void main(String[] args) {
        Q02_TwoSum obj1 = new Q02_TwoSum();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 9;
        System.out.println(Arrays.toString(obj1.twoSum(arr, target)));

    }
}

