// Date: 26 February 2023

package Easy;

import java.util.HashMap;
import java.util.Map;

public class Q2_TwoSum {
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
}

