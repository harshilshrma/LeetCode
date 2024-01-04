// Date: 4 January 2024
// You are given a 0-indexed array nums consisting of positive integers.
//There are two types of operations that you can apply on the array any number of times:
//Choose two elements with equal values and delete them from the array.
//Choose three elements with equal values and delete them from the array.
//Return the minimum number of operations required to make the array empty, or -1 if it is not possible.

package Medium;

import java.util.HashMap;

public class lc2870_MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        var counter = new HashMap<Integer, Integer>();
        int ans = 0;

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        for (int i : counter.values()) {
            if (i == 1) {
                return -1;
            }
            ans += Math.ceil((double) i / 3);
        }

        return ans;
    }

    public static void main(String[] args) {
        lc2870_MinimumNumberOfOperationsToMakeArrayEmpty obj = new lc2870_MinimumNumberOfOperationsToMakeArrayEmpty();
        int[] nums = {2,3,3,2,2,4,2,3,4};
        System.out.println(obj.minOperations(nums));
    }
}
