// Date: June 19, 2023
// Q26: Given an integer array nums and an integer k, return the k most frequent elements. You may return the
// answer in any order.

package Medium;
import java.util.*;

public class Q26_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int count = 0, max = 1, i, j;

        // Creating a HashMap to store the array in key-value pair
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, count);
            }
            map.put(num, map.get(num) + 1);
        }

        // Creating separate arrays for keys and values using EntrySet method in HashMap
        Integer[] keyArray = new Integer[map.size()];
        Integer[] valueArray = new Integer[map.size()];
        i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            keyArray[i] = key;
            valueArray[i] = value;
            i++;
        }

        // Sorting the key-value pair in an increasing order of "values"
        int length = keyArray.length;
        for (i = 0; i < length; i++) {
            for (j = i + 1; j < length; j++) {
                int tempKey = 0;
                int tempValue = 0;
                if (valueArray[i] > valueArray[j]) {
                    tempKey = keyArray[j];
                    keyArray[j] = keyArray[i];
                    keyArray[i] = tempKey;

                    tempValue = valueArray[j];
                    valueArray[j] = valueArray[i];
                    valueArray[i] = tempValue;
                }
            }
        }
        // Now, we have keys and values in separate arrays with valueArray sorted in an increasing manner and the
        // keyArray sorted in a manner such that the key-value pair is not destroyed.

        // Now we will create a new array which will contain the top "k" most frequent elements
        int[] ansArray = new int[k];
        for (i = length - 1, j = 0; j < k ; i--, j++) {
            ansArray[j] = keyArray[i];
        }
        return ansArray;
    }

    // Main function for testing
    public static void main(String[] args) {
        Q26_TopKFrequentElements obj1 = new Q26_TopKFrequentElements();
        int k = 3;
        int[] num = new int[]{1, 1, 2, 3, 4, 4};
        obj1.topKFrequent(num, k);
    }
}
