// Date: 16 February 2024
// Given an array of integers arr and an integer k. Find the least number of unique integers after
// removing exactly k elements.

package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc1481_LeastNoOfUniqueIntAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // HashMap to store frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Create a List containing frequency values
        List<Integer> list = new ArrayList<>(map.values());
        // Sort the list in ascending order
        Collections.sort(list);

        // Iterate through each frequency value in the sorted list
        for (int i = 0; i < list.size(); i++) {
            // Subtract current frequency from k
            k = k - list.get(i);
            // If k becomes negative, return remaining unique integers
            if (k < 0) {
                return list.size() - i;
            }
        }

        // No elements left, all deleted
        return 0;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1481_LeastNoOfUniqueIntAfterKRemovals obj = new lc1481_LeastNoOfUniqueIntAfterKRemovals();
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(obj.findLeastNumOfUniqueInts(arr, k));
    }
}
