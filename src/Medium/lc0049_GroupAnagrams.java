// Date: July 18, 2023
// Q25: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically
// using all the original letters exactly once.

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class lc0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // First of all for the empty strings, we will return an empty Arraylist
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // Declaring a new Hashmap with key = sortedString & value = originalString
        HashMap<String, List<String>> map = new HashMap<>();

        //Now iterating for each string in "strs" one by one,
        for (String originalString : strs) {
            char[] charArray = originalString.toCharArray(); // Converting the strings to characters
            Arrays.sort(charArray); // Sorting the characters
            String sortedString = String.valueOf(charArray); // Converting characters to strings again
            if (!map.containsKey(sortedString)) {
                // Creating a key-value pair of (sortedString, originalString)
                // Here, we use a new ArrayList for the originalString(s) because we have to collect all the strings
                // which are anagram, i.e., all of those which contain the same letters as the sortedString.
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(originalString); // Adding the originalString to our new empty ArrayList
            // described above, which belongs prior to sorting (i.e., in "strs")
            // Now with this "for each" loop, all the anagrams will be one by one, arranged together.
        }
        // Now we will return the list of grouped anagrams which are the values of our Hashmap!
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        lc0049_GroupAnagrams abc1 = new lc0049_GroupAnagrams();
        String[] test = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(abc1.groupAnagrams(test));
    }
}
