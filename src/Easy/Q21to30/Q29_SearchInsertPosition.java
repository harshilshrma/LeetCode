// Date: June 23, 2023
// Q29: Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

package Easy.Q21to30;

import java.util.*;
public class Q29_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, i);
            }

        }
        return 5;
    }

    public static void main(String[] args) {
        Q29_SearchInsertPosition obj1 = new Q29_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        obj1.searchInsert(nums, target);
    }
}
