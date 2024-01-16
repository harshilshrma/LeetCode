// Date: 16 January 2024
// Implement the RandomizedSet class:
//RandomizedSet() Initializes the RandomizedSet object.
//bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
// false otherwise.
//bool remove(int val) Removes an item val from the set if present. Returns true if the item was present,
// false otherwise.
//int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least
// one element exists when this method is called). Each element must have the same probability of being returned.
//You must implement the functions of the class such that each function works in average O(1) time complexity.

package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class lc0380_InsertDeleteGetRandomOof1 {
    // HashMap to store values and their corresponding indices in the list
    HashMap<Integer, Integer> map;

    // List to store values in the order they are inserted
    List<Integer> list;

    // Constructor to initialize the HashMap and List
    public lc0380_InsertDeleteGetRandomOof1() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // Function to insert a value into the set
    public boolean insert(int val) {
        // If the value is already in the set, return false
        if (map.containsKey(val)) {
            return false;
        }

        // Add the value to the list and update its index in the map
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    // Function to remove a value from the set
    public boolean remove(int val) {
        // If the value is not in the set, return false
        if (!map.containsKey(val)) {
            return false;
        }

        // Get the index of the value to be removed and the last value in the list
        int idxToRemove = map.get(val);
        int lastValue = list.get(list.size() - 1);

        // If the value to be removed is not the last one, replace it with the last value
        if (idxToRemove < list.size() - 1) {
            list.set(idxToRemove, lastValue);
            map.put(lastValue, idxToRemove);
        }

        // Remove the last value from the list and update the map
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Function to get a random value from the set
    public int getRandom() {
        // Generate a random index and return the corresponding value from the list
        Random rand = new Random();
        int randIdx = rand.nextInt(list.size());
        return list.get(randIdx);
    }
}
