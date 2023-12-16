// Date: 13 May 2023
// Q23: Given an integer array nums, return true if any value
// appears at least twice in the array, and return false if every element is distinct.

package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// My solution (It is right, but it is of complexity O(n^2))
public class lc0217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) count++;
            }
        }
        if (count == 0) return false;
        if (count > 0) return true;
        return true;
    }
}

// Better Solutions:
// 1. Using Arrays
class abcdd {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}

// 2. Using Hashmap
class sadf {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i],1);
        }
        return false;
    }
}

// 3. Using Hashset
class awdfsgd {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}

