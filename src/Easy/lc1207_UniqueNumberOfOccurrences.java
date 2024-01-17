// Date: 17 January 2024
// Given an array of integers arr, return true if the number of occurrences of each value in the
// array is unique or false otherwise.

package Easy;

import java.util.*;

public class lc1207_UniqueNumberOfOccurrences {

    // Function to check if the occurrences of values in the array are unique
    public boolean uniqueOccurrences(int[] arr) {
        // HashMap to store the count of occurrences for each value in the array
        HashMap<Integer, Integer> map = new HashMap<>();

        // List to store unique occurrences
        List<Integer> list = new ArrayList<>();

        // Count occurrences for each value in the array
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Check if the occurrences are unique
        for (int i : map.keySet()) {
            // If the list already contains the current count,
            // occurrences are not unique
            if (list.contains(map.get(i))) {
                return false;
            }
            // Add the current count to the list
            list.add(map.get(i));
        }

        // If all occurrences are unique, return true
        return true;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1207_UniqueNumberOfOccurrences obj = new lc1207_UniqueNumberOfOccurrences();
        int[] arr = {1,2,2,1,1,3};
        System.out.println(obj.uniqueOccurrences(arr));
    }
}
