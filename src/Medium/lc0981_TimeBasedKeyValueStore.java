// Date: 16 December 2023
// Design a time-based key-value data structure that can store multiple values for the same key at different
// time stamps and retrieve the key's value at a certain timestamp.

// Implement the TimeMap class:
// TimeMap() Initializes the object of the data structure.

// void set(String key, String value, int timestamp) Stores the key with the value at the given time
// timestamp.

// String get(String key, int timestamp) Returns a value such that set was called previously,
// with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the
// largest timestamp_prev. If there are no values, it returns "".

package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class lc0981_TimeBasedKeyValueStore {
    // Creating a record to store the value part of the HashMap
    record Pair<K, V>(K key, V value){}

    // Creating the HashMap
    HashMap<String, List<Pair<String, Integer>>> map;

    // Constructor class
    public lc0981_TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    // Set class
    public void set(String key, String value, int timestamp) {
        // For absent keys
        if (!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        // For pre-existing keys
        map.get(key).add(new Pair<>(value, timestamp));
    }

    // Get class
    public String get(String key, int timestamp) {
        // For keys with no values
        if (!map.containsKey(key)) return "";

        // Applying Binary Search on the timestamp values for all the other keys
        List<Pair<String, Integer>> pairList = map.get(key);
        return binarySearch(pairList, timestamp);
    }

    // Applying binary search on the list of timestamps
    public String binarySearch(List<Pair<String, Integer>> list, int timestamp) {
        int l = 0;
        int r = list.size() - 1;

        while (l < r){
            int m = l + (r - l + 1) / 2;
            if (list.get(m).value() <= timestamp) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return list.get(l).value() <= timestamp
                ? list.get(l).key()
                : "";
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0981_TimeBasedKeyValueStore obj = new lc0981_TimeBasedKeyValueStore();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}