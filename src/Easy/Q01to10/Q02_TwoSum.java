// Date: 26 February 2023

package Easy.Q01to10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q02_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();   //Creating a HashMap with the name 'map'.
        for (int i=0; i <nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i};
            }
            map.put(nums[i], i);  //In this HashMap, the key is an element of nums and the value is its index.
        }
        return null;
    }

    public static void main(String[] args) {
        Q02_TwoSum obj1 = new Q02_TwoSum();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(Arrays.toString(obj1.twoSum(arr, target)));
    }
}

